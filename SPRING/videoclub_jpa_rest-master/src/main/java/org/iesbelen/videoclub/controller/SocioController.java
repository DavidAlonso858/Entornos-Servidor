package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Socio;
import org.iesbelen.videoclub.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/socio")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping(value = {"/", ""})
    public List<Socio> all() {
        log.info("All Socio List");
        return socioService.findAll();
    }

    @PostMapping(value = {"", "/"})
    public Socio createSocio(@RequestBody Socio socio) {
        return this.socioService.save(socio);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Long id) {
        this.socioService.delete(id);
    }
}
