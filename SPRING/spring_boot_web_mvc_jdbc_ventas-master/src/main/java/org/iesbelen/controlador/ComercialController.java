package org.iesbelen.controlador;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    @GetMapping("/comercial")
    public String listar(Model model) {
        List<Comercial> listaComercial = comercialService.listAll();

        model.addAttribute("listaComercial", listaComercial);

        return "comerciales";
    }

    @GetMapping("/comercial/{id}")
    public String detalle(Model model, @PathVariable int id) {
        Comercial com = comercialService.findById(id);

        model.addAttribute("comercial", com);
        return "detalle-comercial";
    }

    @GetMapping("/comercial/crear")
    public String crear(Model model) {
        Comercial comercial = new Comercial();

        model.addAttribute("comercial", comercial);

        return "crear-comercial";
    }

    @PostMapping("/comercial/crear")
    public String crear(@ModelAttribute("coemrcial") Comercial co) {

        comercialService.newComercial(co);

        return "redirect:/comercial";
    }


    @GetMapping("/comercial/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Comercial comercial = comercialService.findById(id);

        model.addAttribute("comercial", comercial);

        return "editar-comercial";
    }

    @PostMapping("comercial/editar/{id}")
    public String editar(@ModelAttribute("comercial") Comercial co) {

        comercialService.update(co);

        return "redirect:/comercial";
    }

    @PostMapping("comercial/borrar/{id}")
    public String borrar(@PathVariable int id) {

        comercialService.delete(id);

        return "redirect:/comercial";
    }
}
