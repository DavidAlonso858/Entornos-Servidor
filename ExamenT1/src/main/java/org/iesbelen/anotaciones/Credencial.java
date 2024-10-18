package org.iesbelen.anotaciones;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@Repeatable(Credenciales.class) // par poder almacenar mas de una
public @interface Credencial {
    String usuario();

    String password();
}
