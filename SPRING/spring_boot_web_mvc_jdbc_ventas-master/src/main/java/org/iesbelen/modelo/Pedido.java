package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Builder para hacer Cliente.builder().nombre(rs.getInt("nombre") en vez del new Cliente
public class Pedido {

    private int id;

    private double total;

    private Date fecha;

    private int id_cliente;

    private int id_comercial;

}
