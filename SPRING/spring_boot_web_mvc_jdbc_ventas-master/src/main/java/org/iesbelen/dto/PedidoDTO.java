package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.iesbelen.modelo.Pedido;

import java.util.Date;

@Data
@AllArgsConstructor
// lombok no incorpora bien herencia
// por eso mejor copiar los atributos y no poner extends
public class PedidoDTO {
    private String nombre_cliente;
    private int id;
    private double total;
    private Date fecha;
    private int id_cliente;
    private int id_comercial;

    public PedidoDTO() {

    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_comercial() {
        return id_comercial;
    }

    public void setId_comercial(int id_comercial) {
        this.id_comercial = id_comercial;
    }

}
