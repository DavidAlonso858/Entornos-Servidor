package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaCustomRepositoryJQLImpl implements PeliculaCustomRepository {

    @Autowired
    EntityManager em;

    @Override
    public List<Pelicula> peliculasOrdenadas(Optional<String[]> orden) {

        // se referencia al nombre de la clase por eso Pelicula con p mayuscula
        StringBuilder query = new StringBuilder("SELECT p FROM Pelicula p");

        if (orden.isPresent()) {
            String[] ord = orden.get();

            String columna = ord[0];
            String sentido = ord[1];
            query.append(" ORDER BY p." + columna + " ");

            if (sentido.equalsIgnoreCase("asc")) {
                query.append(sentido);
            } else if (sentido.equalsIgnoreCase("desc")) {
                query.append(sentido);
            }
        }
        return em.createQuery(query.toString(), Pelicula.class).getResultList();
    }
}
