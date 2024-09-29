public class Operario extends Empleado {
    public Integer codigoTaller;

    public Operario(String nombre, String direccion, String apellido, String telefono, String dni, Integer codigoTaller) {
        super(nombre, direccion, apellido, telefono, dni);
        this.codigoTaller = codigoTaller;
    }
}
