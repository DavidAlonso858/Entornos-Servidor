package org.iesbelen.dao;

import org.iesbelen.model.Pedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoDAOImpl extends AbstractDAOImpl implements PedidoDAO {
    @Override
    public synchronized void create(Pedido pedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO pedido (fecha,idUsuario) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setDate(idx++, Date.valueOf(pedido.getFecha()));
            ps.setInt(idx, pedido.getIdUsuario());

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Cero filas de pedido creadas");
            }
            rsGenKeys = ps.getGeneratedKeys();

            if (rsGenKeys.next()) {
                pedido.setIdPedido(rsGenKeys.getInt(1));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pedido> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Pedido> listPedidos = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM pedido");
            int idx = 1;

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(idx++));
                pedido.setFecha(rs.getDate(idx++).toLocalDate());
                pedido.setIdUsuario(rs.getInt(idx));
                listPedidos.add(pedido);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listPedidos;
    }

    @Override
    public Optional<Pedido> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM pedido WHERE ID=?");

            int idx = 1;

            ps.setInt(idx, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(idx++));
                pedido.setFecha(rs.getDate(idx++).toLocalDate());
                pedido.setIdUsuario(rs.getInt(idx));

                return Optional.of(pedido);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public void update(Pedido pedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE pedido SET fecha=? WHERE ID=?");

            int idx = 1;

            ps.setDate(idx++, Date.valueOf(pedido.getFecha()));
            ps.setInt(idx, pedido.getIdPedido());

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Cero filas de pedido actualizadas");
            }


        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = connectDB();
            ps = conn.prepareStatement("DELETE FROM pedido WHERE ID=?");
            int idx = 1;
            ps.setInt(idx, id); // en la columna uno con el id pasado
            // el ps. lo asigna al ? de la sentencia SQL

            int row = ps.executeUpdate();
            if (row == 0) {
                System.out.println("Cero filas de pedido borradas");
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}
