import java.util.ArrayList;
import java.util.List;

@Tarea(
        tituloTarea = "JavaScript",
        descripcionTarea = "Hacer Ejercicios de JS",
        diaSemana = 2,
        hora = 3
)
@Tarea(
        tituloTarea = "Java",
        descripcionTarea = "Hacer Ejercicios de Java",
        diaSemana = 4,
        hora = 3
)
@Tarea(
        tituloTarea = "HTML",
        descripcionTarea = "Formulario",
        diaSemana = 1,
        hora = 1
)
public class AgendaSemana {
    private String nombreAgenda;
    private List<DatosTarea> datosTarea;

    public AgendaSemana(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        this.datosTarea = new ArrayList<>();
    }

    public static AgendaSemana cargadorTarea(AgendaSemana ag) {
        Tarea[] tareas = AgendaSemana.class.getAnnotationsByType(Tarea.class);
        for (Tarea t : tareas) {
            DatosTarea tarea = null;
            tarea = new DatosTarea(t.tituloTarea(), t.descripcionTarea(), t.diaSemana(), t.hora());
            if (tarea != null) {
                ag.datosTarea.add(tarea);
            }
        }
        return ag;
    }

    @Override
    public String toString() {
        return "AgendaSemana{" +
                "\nnombreAgenda='" + nombreAgenda + '\'' +
                ",\ndatosTarea=" + datosTarea.toString() +
                "\n}";
    }
}
