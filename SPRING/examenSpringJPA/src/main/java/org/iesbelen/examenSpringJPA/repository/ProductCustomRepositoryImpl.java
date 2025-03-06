package org.iesbelen.examenSpringJPA.repository;

import jakarta.persistence.EntityManager;
import org.iesbelen.examenSpringJPA.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @Autowired
    private EntityManager em;

    public List<Product> ordenado(Optional<String[]> orden) {
        StringBuilder query = new StringBuilder("SELECT p FROM Product p");
        if (orden.isPresent()) {
            String ord[] = orden.get();

            String campo = ord[0];
            String sentido = ord[1];
            query.append(" ORDER BY ").append(campo).append(" ").append(sentido);
        } else {
            query.append(" ORDER BY p.name").append(" ").append("ASC");
        }

        return em.createQuery(query.toString(), Product.class).getResultList();
    }
}
