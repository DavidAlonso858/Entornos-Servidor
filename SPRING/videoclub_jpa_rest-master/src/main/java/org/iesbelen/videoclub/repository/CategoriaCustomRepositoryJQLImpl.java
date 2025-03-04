package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesbelen.videoclub.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaCustomRepositoryJQLImpl implements CategoriaCustomRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Categoria> queryCustomCategoria(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        StringBuilder queryBuilder = new StringBuilder("SELECT C FROM Categoria C");

        // si encuentra el optional le agrego eso a la sentencia
        if (buscarOptional.isPresent()) {
            queryBuilder.append(" ").append("WHERE C.nombre like :nombre");
            // el :nombre es para establecerlo luego
        }

        // si encuentra el optional le agrego eso a la sentencia
        if (ordenarOptional.isPresent()) {
            if ("asc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre ASC");
            } else if ("desc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre DESC");
            }
        }

// En este caso se trata de una consulta JPQL, es decir, sintaxis de SQL pero con Entidades de JPA
        Query query = em.createQuery(queryBuilder.toString());

        // explicao los dos : del nombre
        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }

        return query.getResultList();
    }
}