package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    private String nombre;

    private String apellido;


    @OneToOne
    @JoinColumn(name = "tarjeta_id", referencedColumnName = "id") // nombre que yo quiero
    // y la referencia la valor real en el modelo
    private Tarjeta tarjeta;

}
