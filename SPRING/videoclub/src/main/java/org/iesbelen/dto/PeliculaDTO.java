package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDTO {
    private int id_pelicula;
    private String titulo;
    private String descripcion;
    private int anyo_lanzamiento;
    private int id_idioma;
    private int duracion_alquiler;

    private  String idioma_nombre;

}
