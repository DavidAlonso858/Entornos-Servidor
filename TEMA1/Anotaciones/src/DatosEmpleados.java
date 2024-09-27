import java.lang.annotation.*;

@Documented // indica que los elementos deben ser documentados por JavaDoc
@Inherited
// Cuando se aplica esta anotación a cualquier otra anotación en su definición indicará que la anotación se hereda en el esquema de herencia de clases de Java.
@Retention(RetentionPolicy.RUNTIME)
// la anotación debe estar disponible en tiempo de ejecución, para su inspección a través de la reflexión de Java.

@Target(ElementType.TYPE)
// para que se puede usar en clases
@Repeatable(Empleados.class)
public @interface DatosEmpleados {
    String nombre();

    String apellidos();

    String dni();

    String direccion();

    String telefono();

    String clase(); // Directivo, Tecnico, Oficial

    String codigoDespacho() default "1";

    String codigoTaller() default "1";
}

