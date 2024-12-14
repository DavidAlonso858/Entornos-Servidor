package org.iesbelen.dao;

import org.iesbelen.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO {

    @Override
    public synchronized void create(Usuario Usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKey = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO usuario (usuario, contraseña, direccion, rol ) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;

            ps.setString(idx++, Usuario.getUsuario());
            ps.setString(idx++, Usuario.getPassword());
            ps.setString(idx++, Usuario.getDireccion());
            ps.setString(idx++, Usuario.getRol());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero filas de usuario creadas");
            }

            rsGenKey = ps.getGeneratedKeys();

            if (rsGenKey.next()) {
                Usuario.setIdUsuario(rsGenKey.getInt(1));
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
    public List<Usuario> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> listUsuario = new ArrayList<>();
        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM usuario");

            int idx = 1;
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(idx++));
                usuario.setUsuario(rs.getString(idx++));
                usuario.setPassword(rs.getString(idx++));
                usuario.setDireccion(rs.getString(idx++));
                usuario.setRol(rs.getString(idx));

                listUsuario.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listUsuario;
    }

    @Override
    public Optional<Usuario> find(int idUsuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuario WHERE ID=?");

            int idx = 1;
            ps.setInt(idx, idUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(idx++));
                usuario.setUsuario(rs.getString(idx++));
                usuario.setPassword(rs.getString(idx++));
                usuario.setDireccion(rs.getString(idx++));
                usuario.setRol(rs.getString(idx));

                return Optional.of(usuario);
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
    public void update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE usuario SET usuario=?, password=?, direccion=?, rol=? WHERE ID=?");

            int idx = 1;
            ps.setString(idx++, usuario.getUsuario());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx++, usuario.getDireccion());
            ps.setString(idx++, usuario.getRol());
            ps.setInt(idx, usuario.getIdUsuario());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero filas de usuario actualizadas");
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

            ps = conn.prepareStatement("DELETE FROM usuario WHERE ID=?");

            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Cero filas de usuario borradas");
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
    public Optional<Usuario> findLogin(String usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE usuario=?");

            int idx = 1;
            ps.setString(idx, usuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario1 = new Usuario();
                usuario1.setIdUsuario(rs.getInt(idx++));
                usuario1.setUsuario(rs.getString(idx++));
                usuario1.setPassword(rs.getString(idx++));
                usuario1.setDireccion(rs.getString(idx++));
                usuario1.setRol(rs.getString(idx));
                return Optional.of(usuario1);
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
}
