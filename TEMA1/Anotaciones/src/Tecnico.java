public class Tecnico extends Operario{
    String perfil;

    public Tecnico(String nombre, String direccion, String apellido, String telefono, String dni, Integer codigoTaller, String perfil) {
        super(nombre, direccion, apellido, telefono, dni, codigoTaller);
        this.perfil = perfil;
    }
}
