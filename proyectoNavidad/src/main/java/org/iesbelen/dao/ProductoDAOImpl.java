package org.iesbelen.dao;

import org.iesbelen.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl extends AbstractDAOImpl implements ProductoDAO {

    @Override
    public synchronized void create(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO producto(nombre, precio, descripcion, idCategoria) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;

            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setString(idx++, producto.getDescripcion());
            ps.setInt(idx, producto.getIdCategoria());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero filas de producto creadas");
            }

            rsGenKeys = ps.getGeneratedKeys();

            if (rsGenKeys.next()) {
                producto.setIdProducto(rsGenKeys.getInt(1));
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
    public List<Producto> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Producto> listProducto = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM producto");


            while (rs.next()) {
                Producto p = new Producto();
            int idx = 1;
                p.setIdProducto(rs.getInt(idx++));
                p.setNombre(rs.getString(idx++));
                p.setPrecio(rs.getDouble(idx++));
                p.setDescripcion(rs.getString(idx++));
                p.setIdCategoria(rs.getInt(idx));
                listProducto.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }

        return listProducto;
    }

    @Override
    public Optional<Producto> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM producto WHERE ID = ?");

            int idx = 1;

            ps.setInt(idx, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(idx++));
                p.setNombre(rs.getString(idx++));
                p.setPrecio(rs.getDouble(idx++));
                p.setDescripcion(rs.getString(idx++));
                p.setIdCategoria(rs.getInt(idx));

                return Optional.of(p);
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
    public void update(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, descripcion = ? WHERE ID = ?");
            int idx = 1;

            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setString(idx++, producto.getDescripcion());
            ps.setInt(idx, producto.getIdProducto());

            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Se han actulizado 0 filas de producto");
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

            ps = conn.prepareStatement("DELETE FROM producto WHERE ID = ?");

            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Se han borrado 0 filas de producto");
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
