public class Operario extends Empleado {
    public Integer codigoTaller;

    public Operario(String nombre, String direccion, String apellido, String dni, Integer telefono, Integer codigoTaller) {
        super(nombre, direccion, apellido, telefono, dni);
        this.codigoTaller = codigoTaller;
    }

    @Override
    public String toString() {
        return super.toString()+ "Codigo Taller: " + codigoTaller;
    }
}
