package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categoria") // empieza desde aqui ya todo
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    // niego los param de busqueda y orden para entrar
    @GetMapping(value = {"/", ""}, params = {"!buscar", "!ordenar"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorias");
        return this.categoriaService.all();
    }

    //OBTENCION
    @GetMapping(value = {"", "/"})
    public List<Categoria> all(
            @RequestParam("buscar") Optional<String> buscarOptional,
            @RequestParam("ordenar") Optional<String> ordenarOptional
    ) {
        log.info("Accediendo a todas las películas con filtro buscar: %s y ordenar: %s",
                buscarOptional.orElse("VOID"),
                ordenarOptional.orElse("VOID")
        );

        return this.categoriaService.allByQueryFiltersStream(buscarOptional, ordenarOptional);
    }

    @GetMapping("/{id}/numeroPeliculas")
    public int numeroPeliculas(@PathVariable Long id) {
        return this.categoriaService.one(id).getPeliculas().size();
    }

    @GetMapping("/{id}")
    public Categoria one(@PathVariable long id) {
        return this.categoriaService.one(id);
    }

    // CREACION
    @PostMapping({"", "/"})
    public Categoria newCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }

    // EDICION
    @PutMapping("/{id}") // si en la ruta se llama igual no hace falta poner ("id) al lado de Path
    public Categoria replaceCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return this.categoriaService.replace(id, categoria);
    }

    // BORRADO
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        this.categoriaService.delete(id);
    }

}
