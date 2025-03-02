package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_tarjeta")
    private Long id;

    private Date caducidad;

    @OneToOne(mappedBy = "tarjeta") // nombre del atributo en el modelo Tarjeta
    private Socio socio;
}
