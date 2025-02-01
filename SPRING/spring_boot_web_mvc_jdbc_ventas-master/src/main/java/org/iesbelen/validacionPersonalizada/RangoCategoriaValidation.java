package org.iesbelen.validacionPersonalizada;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// Limitado por la clase que le paso
@Constraint(validatedBy = {RangoCatego.class})
public @interface RangoCategoriaValidation {

    // mensaje que devolvera esta validacion en especifico
    public String message() default "La categoría debe ser 100,200,300,400,500,600,700,800 o 1000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //Implementar el array que recoge la posible repetición de la anotación
    //  @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    // @Retention(RetentionPolicy.RUNTIME)
    // @interface List {
    //   RangoCategoriaValidation[] value();
    // }
}
