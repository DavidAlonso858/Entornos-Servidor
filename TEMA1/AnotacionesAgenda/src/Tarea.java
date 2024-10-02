import java.lang.annotation.*;

@Documented // indica que los elementos deben ser docuementados por Javadoc
@Inherited
// Cuando se aplica esta anotacion a cualquier otra anotacion en su deficinicion
// indicara que la anotacion se hereda en el esquema de herecia de clases
// de Java
@Retention(RetentionPolicy.RUNTIME)
// la anotacion debe estar disponible en tiempo de ejecucion,
// para su inspecciona traves de la reflexion de Java

@Target(ElementType.TYPE)
// para que se pueda usar ene clases

@Repeatable(Tareas.class)
public @interface Tarea {
    String tituloTarea();

    String descripcionTarea();

    int diaSemana();

    int hora();

}
