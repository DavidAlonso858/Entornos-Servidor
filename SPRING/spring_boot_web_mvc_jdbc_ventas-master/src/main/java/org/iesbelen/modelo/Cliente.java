package org.iesbelen.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private long id;

    @NotBlank(message = "{error.nombre}")
    @Size(max = 30, message = "{error.nombre.size}")
    private String nombre;

    @NotBlank(message = "{error.apellido1}")
    @Size(max = 30, message = "{error.apellido.size}")
    private String apellido1;

    // opcional por eso no tiene etiqueta
    private String apellido2;

    @NotBlank(message = "{error.ciudad}")
    @Size(max = 50, message = "{error.ciudad.size}")
    private String ciudad;

    @Min(value = 100, message = "{error.categoria.min}")
    @Max(value = 1000, message = "{error.categoria.max}")
    private int categoria;
}
