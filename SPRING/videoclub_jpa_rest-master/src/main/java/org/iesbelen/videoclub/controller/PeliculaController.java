package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamanio"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }

    // tamanio es las peliculas que entran en una pagina 
    @GetMapping(value = {"", "/"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "pagina", defaultValue = "0")
                                                   int pagina,
                                                   @RequestParam(value = "tamanio", defaultValue = "3") int tamanio) {

        log.info("Accediendo a todas la peliculas con paginacion");

        Map<String, Object> responseAll = this.peliculaService.paginacion(pagina, tamanio);

        return ResponseEntity.ok(responseAll);
    }


    @GetMapping(value = {"","/"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "paginado", defaultValue = "0") String[] paginacion) {

        log.info("Accediendo a todas las películas con paginacion");


        Map<String, Object> responseAll = this.peliculaService.paginacionArray(paginacion);

        return ResponseEntity.ok(responseAll);
    }

    @PostMapping({"", "/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {

        return this.peliculaService.save(pelicula);
    }

    @PostMapping("/{id}/add/{id_categoria}") // si en la ruta se llama igual no hace falta poner ("id) al lado de Path
    public void addPelicula(@PathVariable long id, @PathVariable long id_categoria) {
        this.peliculaService.addCategoriaToPelicula(id, id_categoria);
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable long id)
    {
        return this.peliculaService.one(id);
    }

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }
}
