package org.iesbelen.validacionPersonalizada;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RangoCatego implements ConstraintValidator<RangoCategoria, Integer> {

    private RangoCategoria rangoCategoria;
    private List<Integer> CATEGORIAS_VALIDAS = List.of(100, 200, 300, 400, 500, 600, 700, 800, 1000);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext C) {
        return value != null && CATEGORIAS_VALIDAS.contains(value);
    }
}
