package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="idioma")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Para que funcione la coleccion de Set<Categoria> en Pelicula
@EqualsAndHashCode(of = "nombre")

//Si utilizo @OneToMany(FetchType.LAZY) además debo usar
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "idioma") // relacion con el modelo Idioma pillando el atributo concreto
    @JsonIgnore
    private List<Pelicula> peliculasIdioma;

}
