package org.iesbelen.repository;

import org.iesbelen.domain.Pelicula;

import java.util.List;

public interface PeliculaDAO {
    public List<Pelicula> listadoTodas();

    public void crearPelicula(Pelicula pelicula);

}
