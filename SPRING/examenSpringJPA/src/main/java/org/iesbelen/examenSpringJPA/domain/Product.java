package org.iesbelen.examenSpringJPA.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(of = "id")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "descrip", length = 255)
    private String descrip;

    @Column(name = "image_url", length = 120)
    private String image_url;

    @Column(name = "price", precision = 13, scale = 2)
    private BigDecimal price;

    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "cart-item",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private Set<User> usuarios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category categoria;
}
