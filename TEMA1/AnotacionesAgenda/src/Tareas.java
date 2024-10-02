import java.lang.annotation.*;

@Documented

@Inherited

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.TYPE)
public @interface Tareas {
    Tarea[] value();
}
