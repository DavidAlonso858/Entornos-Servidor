package org.iesbelen.model;

public class DepartamentosDTO extends Departamentos {
    private int conteo;

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public DepartamentosDTO(Departamentos departamento, int conteo) {
        this.setCodigo(departamento.getCodigo());
        this.setNombre(departamento.getNombre());
        this.setPresupuesto(departamento.getPresupuesto());
        this.setGastos(departamento.getGastos());
        this.setConteo(conteo);
    }
}
