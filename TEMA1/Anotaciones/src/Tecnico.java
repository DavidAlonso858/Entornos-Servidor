public class Tecnico extends Operario {
    String perfil;

    public Tecnico(String nombre, String direccion, String apellido, String dni, Integer telefono, Integer codigoTaller, String perfil) {
        super(nombre, direccion, apellido, dni, telefono, codigoTaller);
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nPefil: " + perfil;
    }
}
