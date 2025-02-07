package org.iesbelen.controller;

import org.iesbelen.domain.Categoria;
import org.iesbelen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/{id}")
    public String detalle(Model model, @PathVariable int id) {
        Categoria cat = categoriaService.findById(id);

        model.addAttribute("categoria", cat);

        return "categoria/detalle-categoria";
    }
}
