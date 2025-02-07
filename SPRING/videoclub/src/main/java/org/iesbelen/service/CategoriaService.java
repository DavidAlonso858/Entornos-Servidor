package org.iesbelen.service;

import org.iesbelen.domain.Categoria;
import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.CategoriaDTO;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.repository.CategoriaDAO;
import org.iesbelen.repository.PeliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaDAO categoriaDAO;

    public Categoria findById(int id) {
        Optional<Categoria> optCat = categoriaDAO.find(id);

        if (optCat.isPresent()) {
            return optCat.get();
        } else {
            return null;
        }
    }


}
