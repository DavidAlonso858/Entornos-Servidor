package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {

	private int id;

	@NotBlank (message = "Por favor, introduzca un nombre")
	@Size(max = 30, message = "Nombre de maximo 30 caracteres")
	private String nombre;

	@NotBlank (message = "Por favor, introduzca el apellido")
	@Size(max = 30, message = "Apellido de maximo 30 caracteres")
	private String apellido1;

	// opcional por eso no tiene etiqueta
	private String apellido2;
	private float comision;

}
