package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.exception.CategoriaNotFoundException;
import org.iesbelen.videoclub.repository.CategoriaCustomRepository;
import org.iesbelen.videoclub.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaCustomRepository categoriaCustomRepository;

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria Categoria) {
        return this.categoriaRepository.save(Categoria);
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria Categoria) {

        return this.categoriaRepository.findById(id).map(p -> (id.equals(Categoria.getId()) ?
                        this.categoriaRepository.save(Categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(p -> {
                    this.categoriaRepository.delete(p);
                    return p;
                })
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public List<Categoria> allByQueryFiltersStream(Optional<String> buscar, Optional<String> ordenar) {
        return categoriaCustomRepository.queryCustomCategoria(buscar, ordenar);
    }

}