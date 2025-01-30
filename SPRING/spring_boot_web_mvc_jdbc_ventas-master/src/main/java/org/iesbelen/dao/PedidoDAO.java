package org.iesbelen.dao;

import org.iesbelen.modelo.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {
    public int countPedidos();
    public List<Pedido> getPedidoByIdComercial(int id_comercial);
}
