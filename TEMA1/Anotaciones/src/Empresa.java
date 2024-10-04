import java.util.ArrayList;
import java.util.List;

@DatosDirectivo(
        nombre = "Amancio",
        apellidos = "Ortega",
        dni = "66554433F",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = 981185596,
        codigoDespacho = 1
)
@DatosTecnico(
        nombre = "David",
        apellidos = "Alonso",
        dni = "75923724B",
        direccion = "AV.Carlos Haya 83, 3A, MALAGA, MALAGA",
        telefono = 600453611,
        codigoTaller = 4,
        perfil = "tecnico superior"
)
@DatosOficial(
        nombre = "Maria",
        apellidos = "Garcia",
        dni = "88888888D",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = 666666666,
        codigoTaller = 5,
        categoria = "redes"
)
public class Empresa {
    private List<Empleado> empleados;
    private String nombre;


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public static Empresa cargadorDirectivo(Empresa empresa) {
        DatosDirectivo[] directivos = Empresa.class.getAnnotationsByType((DatosDirectivo.class));
        for (DatosDirectivo d : directivos) {
            Empleado directivo = null;
            directivo = new Directivo(d.nombre(), d.apellidos(), d.direccion(), d.dni(), d.telefono(), d.codigoDespacho());
            if (directivo != null) {
                empresa.empleados.add(directivo);
            }
        }
        return empresa;
    }

    public static Empresa cargadorTecnico(Empresa empresa) {
        DatosTecnico[] tecnicos = Empresa.class.getAnnotationsByType((DatosTecnico.class));
        for (DatosTecnico t : tecnicos) {
            Empleado tecnico = null;
            tecnico = new Tecnico(t.nombre(), t.apellidos(), t.direccion(), t.dni(), t.telefono(), t.codigoTaller(), t.perfil());
            if (tecnico != null) {
                empresa.empleados.add(tecnico);
            }
        }
        return empresa;
    }

    public static Empresa cargadorOficial(Empresa empresa) {
        DatosOficial[] oficiales = Empresa.class.getAnnotationsByType((DatosOficial.class));
        for (DatosOficial o : oficiales) {
            Empleado oficial = null;
            oficial = new Oficial(o.nombre(), o.apellidos(), o.direccion(),o.dni(), o.telefono(), o.codigoTaller(), o.categoria());
            if (oficial != null) {
                empresa.empleados.add(oficial);
            }
        }
        return empresa;
    }

    /*public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa("DavidCEO");
        // Sacamos la clase de la empresa para referirnos a ella despues

        // Pillamos las anotaciones en un array
        DatosEmpleados[] empleadosAnotados = Empresa.class.getAnnotationsByType(DatosEmpleados.class);

        // Recorremos el array para procesas todas las anotaciones que teniamos puestas
        for (DatosEmpleados e : empleadosAnotados) {
            String clase = e.clase();
            Empleado empleado = null; //lo declaramos null pa que no pete.

            // diferenciamos por clases ( clase atributo de la anotacion para que cada
            // uno se guarde segun su clase
            switch (clase) {
                case "Directivo":
                    empleado = new Directivo(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoDespacho());
                    break;
                case "Tecnico":
                    empleado = new Tecnico(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.perfil());
                    break;
                case "Oficial":
                    empleado = new Oficial(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.categoria());
                    break;
                default:
                    System.out.println("Clase desconocida: " + clase);
            }

            if (empleado != null) { //para evitar que pese si metemos algo raro y guardamos en al lista
                empresa.empleados.add(empleado);
            }
        }
        return empresa;
    }*/


    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados.toString() +
                ", NOMBRE EMPRESA='" + nombre +
                '}';
    }
}
