package org.iesbelen.dao;

import org.iesbelen.model.Departamentos;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentosDAO {
    @Override
    public synchronized void create(Departamentos departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet keys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setInt(idx++, departamento.getPresupuesto());
            ps.setDouble(idx++, departamento.getGastos());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Se han creado departamentos con 0 filas");
            }

            keys = ps.getGeneratedKeys();

            if (keys.next()) {
                departamento.setCodigo(keys.getInt(1));
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
    public List<Departamentos> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamentos> listDep = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");

            while (rs.next()) {
                Departamentos departamento = new Departamentos();
                int idx = 1;

                departamento.setCodigo(rs.getInt(idx++));
                departamento.setNombre(rs.getString(idx++));
                departamento.setPresupuesto(rs.getInt(idx++));
                departamento.setGastos(rs.getInt(idx++));

                listDep.add(departamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDep;
    }

    @Override
    public Optional<Departamentos> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM departamento WHERE codigo = ?");
            int idx = 1;
            ps.setInt(idx, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Departamentos departamento = new Departamentos();
                departamento.setCodigo(rs.getInt(idx++));
                departamento.setNombre(rs.getString(idx++));
                departamento.setPresupuesto(rs.getInt(idx++));
                departamento.setGastos(rs.getInt(idx));

                return Optional.of(departamento);
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
    public void update(Departamentos departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = connectDB();

            ps = conn.prepareStatement("UPDATE departamento SET nombre = ?, presupuesto = ?, gastos = ? WHERE codigo = ?");

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setInt(idx++, departamento.getPresupuesto());
            ps.setInt(idx++, departamento.getGastos());
            ps.setInt(idx, departamento.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Se han actualizados 0 departamentos");
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

            ps = conn.prepareStatement("DELETE FROM departamento WHERE codigo = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Se han eliminado departamentos con 0 filas");
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
