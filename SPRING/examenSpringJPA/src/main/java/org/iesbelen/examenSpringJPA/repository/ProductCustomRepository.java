package org.iesbelen.examenSpringJPA.repository;

import org.iesbelen.examenSpringJPA.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCustomRepository {
    public List<Product> ordenado(Optional<String[]> orden);
}
