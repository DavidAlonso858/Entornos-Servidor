package org.iesbelen.model;

public class FabricanteDTO extends Fabricante {
    private int conteo;

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public FabricanteDTO() {

    }

    public FabricanteDTO(Fabricante fabricante, int conteo) {
        this.setIdFabricante(fabricante.getIdFabricante());
        this.setNombre(fabricante.getNombre());
        this.setConteo(conteo);
    }
}
