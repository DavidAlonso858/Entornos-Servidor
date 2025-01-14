package org.iesbelen.dao;

import org.iesbelen.model.Empleados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadosDAO {

    @Override
    public synchronized void create(Empleados emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet keys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO empleado (nif,nombre,apellido1,apellido2,codigo_departamento) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;

            ps.setString(idx++, emp.getNif());
            ps.setString(idx++, emp.getNombre());
            ps.setString(idx++, emp.getApellido1());
            ps.setString(idx++, emp.getApellido2());
            ps.setInt(idx, emp.getCodigoDepartamento());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("INSERT de empleados con 0 filas");
            }
            keys = ps.getGeneratedKeys();

            if (keys.next()) {
                emp.setCodigo(keys.getInt(1));
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
    public List<Empleados> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Empleados> listEmpl = new ArrayList<>();

        try {

            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM empleado");

            while (rs.next()) {
                Empleados emp = new Empleados();
                int idx = 1;
                emp.setCodigo(rs.getInt(idx++));
                emp.setNif(rs.getString(idx++));
                emp.setNombre(rs.getString(idx++));
                emp.setApellido1(rs.getString(idx++));
                emp.setApellido2(rs.getString(idx++));
                emp.setCodigoDepartamento(rs.getInt(idx));
                listEmpl.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listEmpl;
    }

    @Override
    public Optional<Empleados> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM empleado WHERE codigo = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Empleados emp2 = new Empleados();

                idx = 1;
                emp2.setCodigo(rs.getInt(idx++));
                emp2.setNif(rs.getString(idx++));
                emp2.setNombre(rs.getString(idx++));
                emp2.setApellido1(rs.getString(idx++));
                emp2.setApellido2(rs.getString(idx++));
                emp2.setCodigoDepartamento(rs.getInt(idx));

                return Optional.of(emp2);
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
    public void update(Empleados emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ? WHERE codigo = ?");
            int idx = 1;

            ps.setString(idx++, emp.getNif());
            ps.setString(idx++, emp.getNombre());
            ps.setString(idx++, emp.getApellido1());
            ps.setString(idx++, emp.getApellido2());
            ps.setInt(idx, emp.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Actualizar de empleados con 0 filas");
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

            ps = conn.prepareStatement("DELETE FROM empleado WHERE codigo = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Se han eliminado 0 filas");
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
