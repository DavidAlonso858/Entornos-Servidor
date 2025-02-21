package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping({"", "/"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }

    @PostMapping({"", "/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @PostMapping("/{id}/add/{id_categoria}")
    public void addPelicula(@PathVariable long id, @PathVariable long id_categoria) {
        Categoria categoriaEncontrada = categoriaService.one(id_categoria); // encuentro la categoria
        Pelicula peliculasEncontrada = peliculaService.one(id); // encuentro la categoria

        peliculasEncontrada.getCategorias().add(categoriaEncontrada);
        this.peliculaService.replace(id, peliculaService.one(id)); // reemplazo la que tenia
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {
        return this.peliculaService.one(id);
    }

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }
}
