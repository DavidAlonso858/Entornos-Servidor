public class Directivo extends Empleado {
    public Integer codigoDespacho;

    public Directivo(String nombre, String direccion, String apellido, String dni, Integer telefono, Integer codigoDespacho) {
        super(nombre, direccion, apellido, telefono, dni);
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + "Codigo Despacho: " + codigoDespacho;
    }
}

