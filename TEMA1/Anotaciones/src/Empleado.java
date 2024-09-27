public class Empleado {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String dni;

    public Empleado(String nombre, String direccion, String apellido, String telefono, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
    }
}
