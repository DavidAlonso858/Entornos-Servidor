package org.iesbelen.validacionPersonalizada;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

// pongo la interfaz de Anotacion al implementar el limitador
// y para que campo va a ser la validacion (integer en categoria o string si fuera un email...)
public class RangoCatego implements ConstraintValidator<RangoCategoriaValidation, Integer> {


    // compruebo si la categoria esta en la lista de las que son validas
    @Override
    public boolean isValid(Integer categoria, ConstraintValidatorContext C) {
        List<Integer> categoriaValidas = List.of(100, 200, 300, 400, 500, 600, 700, 800, 1000);

        return categoria != null && categoriaValidas.contains(categoria);
    }
}