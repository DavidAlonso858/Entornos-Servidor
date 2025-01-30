package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapping.PedidoMapper;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private PedidoMapper pedidoMapper;

    public int conteoTodos() {
        return pedidoDAO.countPedidos();
    }

    public List<PedidoDTO> listPedidosDTO(int idComercial) {

        List<Cliente> clientes = clienteDAO.getAll();
        List<Pedido> pedidos = pedidoDAO.getPedidoByIdComercial(idComercial);

        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        for (Pedido p : pedidos) {
            int idC = p.getId_cliente(); // uso la id del cliente que tiene el pedido
            for (Cliente c : clientes) { // recorro la lista entera de pedidos
                if (c.getId() == idC) { // si coincide
                    pedidosDTO.add(pedidoMapper.pedidoDTO(p, c.getNombre()));
                }
            }
        }
        return pedidosDTO;
    }

    public double mediaPedidos(int total, int concreto) {
        double media;

        System.out.println(concreto);

        media = (double) concreto / total;
        media = media * 100;
        return media;
    }
}