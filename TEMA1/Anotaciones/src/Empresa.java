@DatosEmpleados(
        nombre = "Amancio",
        apellidos = "Ortega",
        dni = "66554433F",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = "981185596",
        clase = "Directivo",
        codigoDespacho = "1"
)
@DatosEmpleados(
        nombre = "David",
        apellidos = "Alonso",
        dni = "75923724B",
        direccion = "AV.Carlos Haya 83, 3A, MALAGA, MALAGA",
        telefono = "600453611",
        clase = "Tecnico",
        codigoTaller = "1"
)
@DatosEmpleados(
        nombre = "Maria",
        apellidos = "Garcia",
        dni = "88888888D",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = "666666666",
        clase = "Oficial",
        codigoTaller = "1"
)
public class Empresa {
    private Empleado[] empleadosEmpresa;
    private String nombre;

    public static Empresa cargadorDeContexto() {
     DatosEmpleados datosEmpleados =   Empresa.class.getAnnotation(DatosEmpleados.class);
        System.out.println(datosEmpleados.apellidos());
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }
}
