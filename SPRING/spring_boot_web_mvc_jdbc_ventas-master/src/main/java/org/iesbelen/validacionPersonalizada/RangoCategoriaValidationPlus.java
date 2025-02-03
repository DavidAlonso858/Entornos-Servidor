package org.iesbelen.validacionPersonalizada;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RangoCategoPlus.class})
public @interface RangoCategoriaValidationPlus {

    int[] values();
    public String message() default "La categoría del cliente no es valida";

}
