package org.iesbelen.dao;

import org.iesbelen.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDAOImpl extends AbstractDAOImpl implements CategoriaDAO {

    @Override
    public synchronized void create(Categoria categoria) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO categoria (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;

            ps.setString(idx++, categoria.getNombre());
            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("INSERT de Categoria con 0 filas insertadas");
            }
            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) {
                categoria.setIdCategoria(rsGenKeys.getInt(1));
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
    public List<Categoria> getAll() {
        Connection conn = null;
        Statement s = null; // solo usa el Statament las listas
        ResultSet rs = null;

        List<Categoria> listCategorias = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM categoria");

            while (rs.next()) {
                Categoria categoria = new Categoria();
                int idx = 1;
                categoria.setIdCategoria(rs.getInt(idx++));
                categoria.setNombre(rs.getString(idx)); // al ultimo no se le suma porque
                // ya se le ha sumado en el anterior
                // idx recorre las columnas como en este caso de la 1 y 2
                listCategorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listCategorias;

    }

    @Override
    public Optional<Categoria> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM categoria WHERE ID = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(idx++));
                categoria.setNombre(rs.getString(idx));

                return Optional.of(categoria);
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
    public void update(Categoria categoria) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE categoria SET nombre = ? WHERE ID = ?");


            int idx = 1;

            ps.setString(idx++, categoria.getNombre());
            ps.setInt(idx, categoria.getIdCategoria());

            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Update de 0 categoria");
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

            ps = conn.prepareStatement("DELETE FROM categoria WHERE ID = ?");

            int idx = 1;
            ps.setInt(idx, id);
            int row = ps.executeUpdate();

            if (row == 0) {
                System.out.println("Se ha borrado 0 categoria");
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
