package org.iesbelen.dao;

import org.iesbelen.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDAOImpl extends AbstractDAOImpl implements CategoriaDAO {
    @Override
    protected Optional<Integer> executeInsert(PreparedStatement ps) throws SQLException {
        return super.executeInsert(ps);
    }

    @Override
    public void create(Categoria categoria) {

    }

    @Override
    public List<Categoria> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Categoria> listaCategorias = new ArrayList<Categoria>();

        try {

            conn = connectDB();
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM categoria");

            while (rs.next()) {
                Categoria cat = new Categoria();
                int idx = 1;
                cat.setIdcat(rs.getInt(idx++));
                cat.setNombre(rs.getString(idx));

                listaCategorias.add(cat);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listaCategorias;
    }

    @Override
    public Optional<Categoria> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM categoria WHERE idcat = ?");
            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Categoria cat = new Categoria();
                idx = 1;
                cat.setIdcat(rs.getInt(idx++));
                cat.setNombre(rs.getString(idx));
                return Optional.of(cat);
            }

        } catch (SQLException | ClassNotFoundException e) {
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

            ps = conn.prepareStatement("UPDATE categoria SET nombre = ? WHERE idcat = ?");
            int idx = 1;
            ps.setString(idx++, categoria.getNombre());
            ps.setInt(idx, categoria.getIdcat());


            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero categorias actualizadas");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public void delete(int id) {

    }
}
