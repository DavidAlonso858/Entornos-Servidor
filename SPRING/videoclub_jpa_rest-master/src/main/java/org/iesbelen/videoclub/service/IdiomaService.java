package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Idioma;
import org.iesbelen.videoclub.exception.CategoriaNotFoundException;
import org.iesbelen.videoclub.exception.IdiomaNotFoundException;
import org.iesbelen.videoclub.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    public List<Idioma> all() {
        return this.idiomaRepository.findAll();
    }

    public Idioma save(Idioma Idioma) {
        return this.idiomaRepository.save(Idioma);
    }

    public Idioma one(Long id) {
        return this.idiomaRepository.findById(id)
                .orElseThrow(() -> new IdiomaNotFoundException(id));
    }

    public Idioma replace(Long id, Idioma Idioma) {

        return this.idiomaRepository.findById(id).map(p -> (id.equals(Idioma.getId()) ?
                        this.idiomaRepository.save(Idioma) : null))
                .orElseThrow(() -> new IdiomaNotFoundException(id));

    }

    public void delete(Long id) {
        this.idiomaRepository.findById(id).map(p -> {
                    this.idiomaRepository.delete(p);
                    return p;
                })
                .orElseThrow(() -> new IdiomaNotFoundException(id));
    }
}