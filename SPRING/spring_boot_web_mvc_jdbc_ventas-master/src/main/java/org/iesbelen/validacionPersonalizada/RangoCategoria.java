package org.iesbelen.validacionPersonalizada;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCatego.class)
public @interface RangoCategoria {
    String message() default "La categoría debe ser 100, 200, 300, 400, 500, 600, 700, 800 o 1000";

    //Para validación en wizards, poco uso en la actualidad
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    //Implementar el array que recoge la posible repetición de la anotación
    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        RangoCategoria[] value();
    }
}