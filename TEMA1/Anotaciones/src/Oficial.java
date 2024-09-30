public class Oficial extends Operario {
    public String categoria;

    public Oficial(String nombre, String direccion, String apellido, String dni, Integer telefono, Integer codigoTaller, String categoria) {
        super(nombre, direccion, apellido, dni, telefono, codigoTaller);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nCategoria: " + categoria;
    }
}
