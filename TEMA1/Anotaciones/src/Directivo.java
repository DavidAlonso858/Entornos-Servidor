public class Directivo extends Empleado {
    public Integer codigoDespacho;

    public Directivo(String nombre, String direccion, String apellido, String telefono, String dni, Integer codigoDespacho) {
        super(nombre, direccion, apellido, telefono, dni);
        this.codigoDespacho = codigoDespacho;
    }
}

