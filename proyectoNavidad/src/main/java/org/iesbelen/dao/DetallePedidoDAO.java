package org.iesbelen.dao;

import org.iesbelen.model.DetallesPedido;
import org.iesbelen.model.Producto;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoDAO {
    public void create(DetallesPedido detallesPedido);
    public List<DetallesPedido> findByPedidoId(int idPedido);
    public List<DetallesPedido> getAll();

    public Optional<DetallesPedido> find(int id);

    public void update(DetallesPedido detallesPedido);

    public void delete(int id);

}
