package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.modelo.Pedido;

import java.util.Date;

@Data // reemplaza los getter y setter tambien vale la anotacion @getter y @setter
@AllArgsConstructor // devuelve un constructor con todos los argumentos
@NoArgsConstructor // devuelve un constructor sin argumentos
// lombok no incorpora bien herencia
// por eso mejor copiar los atributos y no poner extends
public class PedidoDTO {
    private String nombre_cliente;
    private int id;
    private double total;
    private int fecha;
    private int id_cliente;
    private int id_comercial;

}
