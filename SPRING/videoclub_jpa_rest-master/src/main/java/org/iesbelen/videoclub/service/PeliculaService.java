package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.iesbelen.videoclub.repository.PeliculaCustomRepository;
import org.iesbelen.videoclub.repository.PeliculaRepository;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private PeliculaCustomRepository peliculaCustomRepository;

    // invocacion al repositorio sin paginacion
    public List<Pelicula> all() {

        return this.peliculaRepository.findAll();
    }

    public Pelicula save(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    public Pelicula one(Long id) {
        return this.peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula replace(Long id, Pelicula pelicula) {

        return this.peliculaRepository.findById(id).map(p -> (id.equals(pelicula.getIdPelicula()) ?
                        this.peliculaRepository.save(pelicula) : null))
                .orElseThrow(() -> new PeliculaNotFoundException(id));

    }

    public void delete(Long id) {
        this.peliculaRepository.findById(id).map(p -> {
                    this.peliculaRepository.delete(p);
                    return p;
                })
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula peliculasDuracionMenorCantidad(int cantidad) {
        return this.peliculaRepository.findByDuracionLessThan(cantidad);
    }

    // AGREGA CATEGORIA A LA PELICULA EN EL POST
    public boolean addCategoriaToPelicula(long idPelicula, long idCategoria) {
        boolean res = false;

        Categoria categoria = categoriaService.one(idCategoria);
        Pelicula pelicula = this.one(idPelicula);

        res = pelicula.getCategorias().add(categoria)
                && categoria.getPeliculas().add(pelicula); // se trabaja con los modelos por eso se lo agrego a los dos

        if (res) {
            this.replace(idPelicula, pelicula);
        }
        return res;
    }


    // PAGINACION
    public Map<String, Object> paginacion(int pagina, int tamanio) {
        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("idPelicula").ascending());

        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> mapilla = new HashMap<>();

        mapilla.put("peliculas", pageAll.getContent());
        mapilla.put("paginaActual", pageAll.getNumber());
        mapilla.put("totalElementos", pageAll.getTotalElements());
        mapilla.put("totalPages", pageAll.getTotalPages());

        return mapilla;
    }


    public Map<String, Object> paginacionArray(String[] paginacion) {
        Pageable paginado = PageRequest.of(Integer.parseInt(paginacion[0]), Integer.parseInt(paginacion[1]), Sort.by("idPelicula").ascending());
        // igual que el ejemplo pero pasando a int los atributos del array de string
        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("peliculas", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalPages", pageAll.getTotalPages());
        response.put("totalElements", pageAll.getTotalElements());
        return response;
    }

    public List<Pelicula> peliculasOrdenadas(Optional<String[]> orden) {
        return peliculaCustomRepository.peliculasOrdenadas(orden);
    }
}
