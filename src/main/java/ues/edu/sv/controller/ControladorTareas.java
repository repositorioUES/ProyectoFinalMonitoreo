
package ues.edu.sv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ues.edu.sv.interfaceService.ISubtareasService;
import ues.edu.sv.model.Tarea;
import ues.edu.sv.interfaceService.ITareaService;
import ues.edu.sv.model.Subtarea;

@Controller
@RequestMapping
public class ControladorTareas {
    
    @Autowired
    private ITareaService service; 
    
    @Autowired
    private ISubtareasService subtareaService;
      
    @GetMapping("/tareas")
    public String listar(Model model){
        List<Tarea> tareas=service.Listar();
        for (Tarea t: tareas) {
            int id = t.getId();
            t.setAvance(getAvanceTarea(id));
        }
        model.addAttribute("tareas", tareas);
        model.addAttribute("avanceTotalProyecto", getAvanceProyecto());
        return "indexTarea";
    }
    
    @GetMapping("/newTarea")
    public String agregar(Model model){
        model.addAttribute("tarea", new Tarea());
        return "formCrearTarea";
    }
    
    @PostMapping("/saveTarea")
    public String save(@Valid Tarea t,Model model){
        service.save(t);
        return "redirect:/tareas";
    }
    
    @GetMapping("/editarTarea/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Tarea>tarea=service.ListarId(id);
        model.addAttribute("tarea", tarea);
        return "formEditarTarea";
    }
    
    @GetMapping("/eliminarTarea/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);//se elimina la tarea
        ArrayList<Subtarea> subtareas = subtareaService.ListarIdTarea(id);
        for (Subtarea s: subtareas) {
            subtareaService.delete(s.getId());//se elimina tambien las subtareas que tenia la tarea
        }
        return "redirect:/tareas";
    }
    
    @GetMapping("/subtareas/{id}")
    public String mostrarSubtareas(@PathVariable int id, Model model){
        ArrayList<Subtarea> subtareas = subtareaService.ListarIdTarea(id);
        Optional<Tarea> tareaAsignada = service.ListarId(id);
        
        model.addAttribute("subtareas", subtareas);
        model.addAttribute("avance", getAvanceTarea(id)); //necesario para mostrar avance en el index de subtareas
        model.addAttribute("idTarea", id);//id de la tarea a la que pertenece la subtarea
        model.addAttribute("nombreTarea", tareaAsignada.get().getNombre());
        return "index";
    }
    
    @GetMapping("/new/{id}")
    public String crearSubtarea(@PathVariable int id, Model model){
        Optional<Tarea> tareaAsignada = service.ListarId(id);
        model.addAttribute("idTarea", id);
        model.addAttribute("subtarea", new Subtarea());
        model.addAttribute("nombreTarea", tareaAsignada.get().getNombre());
        return "formCrearSubtarea";
    }
    
    public int getAvanceTarea(int id){ //Se obtiene el avance total de la tarea(en base al avance de las subtareas)
        int sumaTotal = 0;
        ArrayList<Subtarea> subtareas = subtareaService.ListarIdTarea(id);
         for (Subtarea s : subtareas) {
            sumaTotal += s.getPorcentaje();
        }
        if(subtareas.size() != 0)
            return (sumaTotal/subtareas.size());
        else
            return 0;
    }
    
    public int getAvanceProyecto(){ //Se obtiene el avance total del proyecto(en base al avance de las tareas)
        int sumaTotal = 0;
        List<Tarea> tareas = service.Listar();
         for (Tarea t : tareas) {
            sumaTotal += t.getAvance();
        }

        if(tareas.size() != 0)
            return (sumaTotal/tareas.size());
        else
            return 0;
        }

}



