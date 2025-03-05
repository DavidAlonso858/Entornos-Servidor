package org.iesbelen.videoclub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Embeddable // anotacion para pillar los atributos de esta clase en Socio
public class Address {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int addressId;

    private String street;

    private int houseNumber;

    private String city;

    private int zipCode;
}
