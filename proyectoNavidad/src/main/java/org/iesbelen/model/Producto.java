package org.iesbelen.model;

public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private int idCategoria;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo_categoria() {
        return idCategoria;
    }

    public void setCodigo_categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

}