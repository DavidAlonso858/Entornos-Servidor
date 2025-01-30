package org.iesbelen.modelo;

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

    @NotBlank(message = "Por favor, introduzca un nombre")
    @Size(max = 30, message = "Nombre de maximo 30 caracteres")
    private String nombre;

    @NotBlank(message = "Por favor, introduzca un apellido")
    @Size(max = 30, message = "Apellido de maximo 30 caracteres")
    private String apellido1;

// opcional por eso no tiene etiqueta
    private String apellido2;

    @NotBlank(message = "Por favor, introduzca una ciudad")
    @Size(max = 50, message = "Ciudad de maximo 50 caracteres")
    private String ciudad;

    private int categoria;

}
