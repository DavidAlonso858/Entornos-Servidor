package org.iesbelen.anotaciones;

public class DatosCredencial {
    private String usuario;
    private String contraseña;

    public DatosCredencial(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "DatosCredencial{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
