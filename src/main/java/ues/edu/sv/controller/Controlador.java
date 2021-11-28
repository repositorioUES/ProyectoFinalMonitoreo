
package ues.edu.sv.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ues.edu.sv.model.Subtarea;
import ues.edu.sv.interfaceService.ISubtareasService;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private ISubtareasService subtareaService;
    
      
    @GetMapping("/")
    public String listar(Model model){
        return "proyecto";
    }
    
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("subtarea", new Subtarea());
        return "formCrearSubtarea";
    }
    
    @PostMapping("/save/{idTareaAsignada}")
    public String save(@Valid Subtarea p,@PathVariable int idTareaAsignada){
        subtareaService.save(p, idTareaAsignada);
        return "redirect:/subtareas/{idTareaAsignada}";
    }
    
    @GetMapping("/editar/{idTareaAsignada}/{id}")
    public String editar(@PathVariable int idTareaAsignada, @PathVariable int id,Model model){
        Optional<Subtarea>subtarea =subtareaService.ListarId(id);
        model.addAttribute("subtarea", subtarea);
        model.addAttribute("idTarea",idTareaAsignada);
        return "formEditarSubtarea";
    }

    
    @GetMapping("/eliminar/{idTareaAsignada}/{id}")
    public String eliminar(@PathVariable int idTareaAsignada, @PathVariable int id, Model model){
        subtareaService.delete(id);                   
        return "redirect:/subtareas/{idTareaAsignada}";
    }
    

}
