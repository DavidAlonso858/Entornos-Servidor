package org.iesbelen.videoclub.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Data
@AllArgsConstructor
@NoArgsConstructor

// Para que funcione la coleccion Set<Pelicula> en Categoria
@EqualsAndHashCode(of = "idPelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private long idPelicula;

    private String titulo;

    private String descripcion;

    @Column(name = "anyo_lanzamiento")
    @JsonFormat(pattern = "yyyy", shape = JsonFormat.Shape.STRING)
    private Year anyoLanzamiento;

    @ManyToOne()
    @JoinColumn(name = "id_idioma", nullable = false) // nombre del atributo en la tabla BD
    private Idioma idioma;

    private int duracion;

    @ManyToMany
    @JoinTable(
            name = "pelicula_categoria", // nombre de la tabla
            joinColumns = @JoinColumn(name = "id_pelicula"), // name tabla intermedia // referenced el de la principal
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))

    Set<Categoria> categorias = new HashSet<>();

}
