package org.iesbelen.validacionPersonalizada;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangoCategoPlus implements ConstraintValidator<RangoCategoriaValidationPlus, Integer> {

    private int[] valuesValidos;
    private int max;
    private int min;

    @Override
    public void initialize(RangoCategoriaValidationPlus constraintAnnotation) {
        valuesValidos = constraintAnnotation.values();
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        if (integer >= min && integer <= max) {
            for (int v : valuesValidos) {
                if (v == integer) {
                    return true;
                }
            }
        }

        return false;
    }
}

