package org.iesbelen.dao;

import org.iesbelen.model.DetallesPedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetallePedidoDAOImpl extends AbstractDAOImpl implements DetallePedidoDAO {

    @Override
    public synchronized void create(DetallesPedido detallesPedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO detallepedido (cantidad, idProducto, idPedido) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;

            ps.setInt(idx++, detallesPedido.getCantidad());
            ps.setInt(idx++, detallesPedido.getIdProducto());
            ps.setInt(idx, detallesPedido.getIdPedido());

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("cero filas de detalle pedido insertado");
            }

            rsGenKeys = ps.getGeneratedKeys();

            if (rsGenKeys.next()) {
                detallesPedido.setId(rsGenKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public List<DetallesPedido> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<DetallesPedido> listDP = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM detallepedido");

            int idx = 1;
            while (rs.next()) {
                DetallesPedido detallesPedido = new DetallesPedido();
                detallesPedido.setId(idx++);
                detallesPedido.setCantidad(rs.getInt(idx++));
                detallesPedido.setIdProducto(rs.getInt(idx++));
                detallesPedido.setIdPedido(rs.getInt(idx));
                listDP.add(detallesPedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDP;
    }

    @Override
    public Optional<DetallesPedido> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM detallepedido WHERE ID = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                DetallesPedido detallesPedido = new DetallesPedido();
                detallesPedido.setId(idx++);
                detallesPedido.setCantidad(rs.getInt(idx++));
                detallesPedido.setIdProducto(rs.getInt(idx++));
                detallesPedido.setIdPedido(rs.getInt(idx));

                return Optional.of(detallesPedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return Optional.empty();
    }


    @Override
    public void update(DetallesPedido detallesPedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE detallepedido SET cantidad = ? WHERE ID = ?");

            int idx = 1;

            ps.setInt(idx++, detallesPedido.getCantidad());
            ps.setInt(idx, detallesPedido.getId());

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Se ha actualizado 0 detalle pedido");
            }

        } catch (SQLException e) {
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

            ps = conn.prepareStatement("DELETE FROM detallepedido WHERE ID = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Se han borrado 0 filas en detalle pedido");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}
