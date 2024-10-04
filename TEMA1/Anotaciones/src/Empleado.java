public class Empleado {
    private String nombre;
    private String apellido;
    private String direccion;
    private Integer telefono;
    private String dni;

    public Empleado(String nombre, String apellido,String direccion, Integer telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
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
