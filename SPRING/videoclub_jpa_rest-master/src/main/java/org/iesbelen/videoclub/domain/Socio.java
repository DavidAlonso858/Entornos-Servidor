package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_socio")
    private Long id;

    @NaturalId
    private String dni;

    private String nombre;

    private String apellido;


    @OneToOne() // para que se elimene aun estando relacionado cascade = CascadeType.Persist
    @JoinColumn(name = "id_tarjeta") // nombre que yo quiero
    // y la referencia la valor real en el modelo
    private Tarjeta tarjeta;

    @ElementCollection
    @CollectionTable(name = "socio_address", joinColumns = @JoinColumn(name = "socio_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
    })
    private Set<Address> addresses = new HashSet<>();

    @Embedded // anotacion para pillar los atributos de la otra clase
    private Address addressClase;

    @ElementCollection
    @CollectionTable(name = "socio_phone_numbers", joinColumns = @JoinColumn(name = "socio_id"))
    @Column(name = "phone_numbers")
    private Set<String> phoneNumbers;

}
