package org.iesbelen.service;

import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.mapping.PeliculaMapper;
import org.iesbelen.repository.IdiomaDAO;
import org.iesbelen.repository.PeliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaDAO peliculaDAO;
    @Autowired
    private IdiomaDAO idiomaDAO;
    @Autowired
    private PeliculaMapper peliculaMapper;

    public List<PeliculaDTO> listAll() {

        List<Idioma> listaIdioma = idiomaDAO.listIdioma();
        List<Pelicula> listaPelicula = peliculaDAO.listadoTodas();

        List<PeliculaDTO> peliculasDTO = new ArrayList<>();

        for (Idioma idioma : listaIdioma) {
            int id_idioma = idioma.getId_idioma();
            for (Pelicula pelicula : listaPelicula) {
                if (id_idioma == pelicula.getId_idioma()) {
                    peliculasDTO.add(peliculaMapper.peliculaDTO(pelicula, idioma.getNombre()));
                }
            }
        }

        return peliculasDTO;
    }

    public void newPelicula(Pelicula pelicula) {

        peliculaDAO.crearPelicula(pelicula);
    }

}
