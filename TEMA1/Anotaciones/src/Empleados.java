import java.lang.annotation.*;

// TODAS LAS ANOTACIONES DE EMPLEADO DEBEN ESTAR EN EMPLEADO
@Documented // indica que los elementos deben ser documentados por JavaDoc
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// para que se puede usar en clases
public @interface Empleados {
    DatosEmpleados[] value();
}
