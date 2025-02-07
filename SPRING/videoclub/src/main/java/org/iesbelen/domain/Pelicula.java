package org.iesbelen.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    private int id_pelicula;

    @NotBlank(message = "{error.titulo}")
    @Size(min = 2, message = "{error.minimo}")
    private String titulo;

    @Size(max = 300, message = "{error.maximo}")
    private String descripcion;

    @Max(value = 1895, message = "{error.anyo}")
    private int anyo_lanzamiento;

    private int id_idioma;

    @Min(value = 1, message = "{error.duracion}")
    private int duracion_alquiler;
}
