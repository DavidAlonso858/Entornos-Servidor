public class Empleado {
    private String nombre;
    private String apellido;
    private String direccion;
    private Integer telefono;
    private String dni;

    public Empleado(String nombre, String direccion, String apellido, Integer telefono, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nNombre: " + nombre + "\n");
        sb.append("Apellido: " + apellido + "\n");
        sb.append("Direccion: " + direccion + "\n");
        sb.append("DNI: " + dni + "\n");
        sb.append("Telefono: " + telefono + "\n");
        return sb.toString();
    }
}
