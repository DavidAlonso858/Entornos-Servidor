package org.iesbelen.examenSpringJPA.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "username", length = 120, unique = true)
    private String username;

    @Column(name = "password", length = 120)
    private String password;

    @ManyToMany(mappedBy = "usuarios")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

}
