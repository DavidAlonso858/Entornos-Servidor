public class Oficial extends Operario{
    public String categoria;

    public Oficial(String nombre, String direccion, String apellido, String telefono, String dni, Integer codigoTaller, String categoria) {
        super(nombre, direccion, apellido, telefono, dni, codigoTaller);
        this.categoria = categoria;
    }
}
