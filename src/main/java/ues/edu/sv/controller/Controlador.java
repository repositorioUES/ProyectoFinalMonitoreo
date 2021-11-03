
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
import ues.edu.sv.model.Subtarea;
import ues.edu.sv.interfaceService.ISubtareasService;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private ISubtareasService service;
    
    @GetMapping("/")
    public String listar(Model model){
        List<Subtarea>subtareas=service.Listar();
        model.addAttribute("subtareas", subtareas);
        return "index";
    }
    
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("subtarea", new Subtarea());
        return "form";
    }
    
    @PostMapping("/save")
    public String save(@Valid Subtarea p, Model model){
        service.save(p);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Subtarea>subtarea=service.ListarId(id);
        model.addAttribute("subtarea", subtarea);
        return "form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/";
    }
}
