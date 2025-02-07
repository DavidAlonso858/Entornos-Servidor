package org.iesbelen.controller;

import jakarta.validation.Valid;
import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.service.IdiomaService;
import org.iesbelen.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping("/peliculas")
    public String peliculas(Model model) {
        List<PeliculaDTO> listaPeliculas = peliculaService.listAll();

        model.addAttribute("listaPeliculas", listaPeliculas);

        return "peliculas/peliculas";
    }

    @GetMapping("/peliculas/crear")
    public String crearPeliculas(Model model) {

        List<Idioma> listaIdioma = idiomaService.getAllIdioma();
        Pelicula pelicula = new Pelicula();

        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listaIdiomas", listaIdioma);

        return "peliculas/crear-pelicula";
    }

    @PostMapping("/peliculas/crear")
    public String crear(@Valid @ModelAttribute Pelicula pelicula, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<Idioma> listaIdioma = idiomaService.getAllIdioma();
            model.addAttribute("pelicula", pelicula);
            model.addAttribute("listaIdiomas", listaIdioma);
            return "peliculas/crear-pelicula";

        }

        peliculaService.newPelicula(pelicula);

        return "redirect:/peliculas";
    }
}
