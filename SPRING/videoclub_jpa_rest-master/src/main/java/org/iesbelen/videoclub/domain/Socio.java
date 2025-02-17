package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String dni;

    private String nombre;

    private String apellido;


    @OneToOne
    @JoinColumn(name = "tarjeta_id", referencedColumnName = "id") // nombre que yo quiero
    // y la referencia la valor real en el modelo
    private Tarjeta tarjeta;

    @ElementCollection
    @CollectionTable(name = "socio_address", joinColumns = @JoinColumn(name = "socio_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
    })
    private Set<Address> addresses = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "socio_phone_numbers", joinColumns = @JoinColumn(name = "socio_id"))
    @Column(name = "phone_numbers")
    private Set<String> phoneNumbers;

}
