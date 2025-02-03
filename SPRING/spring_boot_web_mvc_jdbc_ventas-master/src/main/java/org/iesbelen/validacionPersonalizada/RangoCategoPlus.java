package org.iesbelen.validacionPersonalizada;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangoCategoPlus implements ConstraintValidator<RangoCategoriaValidationPlus, Integer> {

    int[] valuesValidos;

    @Override
    public void initialize(RangoCategoriaValidationPlus constraintAnnotation) {
       valuesValidos = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
