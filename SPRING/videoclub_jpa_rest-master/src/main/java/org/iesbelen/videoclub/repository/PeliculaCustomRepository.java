package org.iesbelen.videoclub.repository;

import org.iesbelen.videoclub.domain.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaCustomRepository {
    List<Pelicula> peliculasOrdenadas(Optional<String[]> orden);
}
