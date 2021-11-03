
package ues.edu.sv.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import ues.edu.sv.model.Tarea;
import ues.edu.sv.interfaceService.ITareaService;

@Controller
@RequestMapping
public class ControladorTareas {
    
    @Autowired
    private ITareaService service; 
      
    @GetMapping("/tareas")
    public String listar(Model model){
        List<Tarea> tareas=service.Listar();
        model.addAttribute("tareas", tareas);
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
        return "formModificarTarea";
    }
    
    @GetMapping("/eliminarTarea/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/tareas";
    }
}
