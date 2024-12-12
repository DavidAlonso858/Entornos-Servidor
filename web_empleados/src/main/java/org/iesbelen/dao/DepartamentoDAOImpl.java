package org.iesbelen.dao;

import org.iesbelen.model.Departamento;
import org.iesbelen.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO {

    @Override
    public synchronized void create(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet keys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES  (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setInt(idx++, departamento.getPresupuesto());
            ps.setInt(idx++, departamento.getGastos());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("INSERT de departamento con 0 filas");
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
    public List<Departamento> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> listDe = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");
            while (rs.next()) {
                Departamento de = new Departamento();
                int idx = 1;
                de.setCodigo(rs.getInt(idx++));
                de.setNombre(rs.getString(idx++));
                de.setPresupuesto(rs.getInt(idx++));
                de.setGastos(rs.getInt(idx++));
                listDe.add(de);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDe;
    }

    @Override
    public Optional<Departamento> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Departamento departamento) {

    }

    @Override
    public void delete(int id) {

    }
}
