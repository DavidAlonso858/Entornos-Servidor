package org.iesbelen.dao;

import org.iesbelen.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl extends AbstractDAOImpl implements ProductoDAO {

    @Override
    public List<Producto> busquedaStock(int stock) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Producto> listaProductos = new ArrayList<>();
        try {
            conn = connectDB();

            String consulta = "SELECT * FROM producto WHERE (stock) = ?";
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, stock);

            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pro = new Producto();
                int idx = 1;
                pro.setIdprod(rs.getInt(idx++));
                pro.setIdcat(rs.getInt(idx++));
                pro.setNombre(rs.getString(idx++));
                pro.setPrecio(rs.getInt(idx++));
                pro.setStock(rs.getInt(idx));

                listaProductos.add(pro);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return listaProductos;
    }

    @Override
    public List<Producto> filtroPresupuesto(double menor, double mayor) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Producto> listPro = new ArrayList<>();

        try {
            conn = connectDB();

            String consulta = "SELECT * FROM producto WHERE (precio) >= ? AND (precio) <= ?";
            ps = conn.prepareStatement(consulta);
            ps.setDouble(1, menor);
            ps.setDouble(2, mayor);

            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pro = new Producto();
                int idx = 1;
                pro.setIdprod(rs.getInt(idx++));
                pro.setIdcat(rs.getInt(idx++));
                pro.setNombre(rs.getString(idx++));
                pro.setPrecio(rs.getInt(idx++));
                pro.setStock(rs.getInt(idx));

                listPro.add(pro);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return listPro;
    }

    @Override
    public synchronized void create(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet keys = null;

        try {

            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO producto (idcat, nombre, precio, stock) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            int idx = 1;
            ps.setInt(idx++, producto.getIdcat());
            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setInt(idx++, producto.getStock());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero productos creados");
            }
            keys = ps.getGeneratedKeys();

            if (keys.next()) {
                producto.setIdprod(keys.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Producto> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Producto> listaProductos = new ArrayList<>();

        try {

            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM producto");

            while (rs.next()) {
                Producto producto = new Producto();
                int idx = 1;
                producto.setIdprod(rs.getInt(idx++));
                producto.setIdcat(rs.getInt(idx++));
                producto.setNombre(rs.getString(idx++));
                producto.setPrecio(rs.getDouble(idx++));
                producto.setStock(rs.getInt(idx));

                listaProductos.add(producto);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }

        return listaProductos;
    }

    @Override
    public Optional<Producto> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(int id) {

    }
}
