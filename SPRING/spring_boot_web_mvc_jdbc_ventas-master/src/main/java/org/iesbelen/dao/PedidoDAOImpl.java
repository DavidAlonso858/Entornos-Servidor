package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PedidoDAOImpl implements PedidoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pedido> getallPedidos() {
        List<Pedido> listaPedidos = jdbcTemplate.query("SELECT * FROM pedido",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")
                )
        );

        log.info("Lista con {} pedidos.", listaPedidos.size());
        return listaPedidos;
    }

    @Override
    public List<Pedido> getPedidoByIdComercial(int id_comercial) {

        List<Pedido> listaPedidos = jdbcTemplate.query("SELECT * FROM pedido WHERE id_comercial = ?",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")
                ),id_comercial
        );

        log.info("Lista con {} pedidos de ese comercial.", listaPedidos.size());
        return listaPedidos;
    }
}
