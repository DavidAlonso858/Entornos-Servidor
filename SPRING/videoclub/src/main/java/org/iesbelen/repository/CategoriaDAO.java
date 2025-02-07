package org.iesbelen.repository;

import org.iesbelen.domain.Categoria;

import java.util.Optional;

public interface CategoriaDAO {
    public Optional<Categoria> find(int id_categoria);
}
