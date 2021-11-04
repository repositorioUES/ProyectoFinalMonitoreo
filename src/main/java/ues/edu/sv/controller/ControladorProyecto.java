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
import ues.edu.sv.interfaceService.IProyectoService;
import ues.edu.sv.model.Proyecto;

@Controller
@RequestMapping
public class ControladorProyecto {

    @Autowired
    private IProyectoService service;

    @GetMapping("/proyecto")
    public String listar(Model model) {
        List<Proyecto> proyectos = service.Listar();
        model.addAttribute("proyectos", proyectos);
        return "proyecto";
    }

    @GetMapping("/newProyecto")
    public String agregar(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "formProyecto";
    }

    @PostMapping("/saveProyecto")
    public String save(@Valid Proyecto pr, Model model) {
        service.save(pr);
        return "redirect:/proyecto";
    }

    @GetMapping("/editarProyecto/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Proyecto> proyecto = service.ListarId(id);
        model.addAttribute("proyecto", proyecto);
        return "formEditarProyecto";
    }

    @GetMapping("/eliminarProyecto/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        service.delete(id);
        return "redirect:/proyecto";
    }
}
