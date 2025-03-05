package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Tarjeta;
import org.iesbelen.videoclub.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping(value = {"", "/"})
    public List<Tarjeta> all() {
        log.info("Todas las tarjetas");
        return this.tarjetaService.findAll();
    }

    @PostMapping(value = {"", "/"})
    public Tarjeta add(@RequestBody Tarjeta tarjeta) {
        log.info("Creando tarjeta");

        return this.tarjetaService.create(tarjeta);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.tarjetaService.delete(id);
    }

}
