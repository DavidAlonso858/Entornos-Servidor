package org.iesbelen.dao;

import java.security.Key;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j // gracias a esta anotacion va el log.info
@Repository
//Utilizo lombok para generar el constructor
@AllArgsConstructor
public class ComercialDAOImpl implements ComercialDAO {

    //JdbcTemplate se inyecta por el constructor de la clase automáticamente
    //
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public synchronized void create(Comercial comercial) {

        String sql = """
                    INSERT INTO comercial (nombre, apellido1, apellido2, comisión) 
                    VALUES (?, ?, ?, ?)
                """;

        KeyHolder key = new GeneratedKeyHolder(); // para conseguir las id de la bd
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            // para almacenar las id
            int idx = 1;

            ps.setString(idx++, comercial.getNombre());
            ps.setString(idx++, comercial.getApellido1());
            ps.setString(idx++, comercial.getApellido2());
            ps.setBigDecimal(idx, comercial.getComision());

            return ps;
        }, key);

        comercial.setId(key.getKey().intValue());
    }

    @Override
    public List<Comercial> getAll() {

        List<Comercial> listComercial = jdbcTemplate.query(
                "SELECT * FROM comercial",
                (rs, rowNum) -> new Comercial(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getBigDecimal("comisión"))

        );

        log.info("Devueltos {} registros.", listComercial.size());

        return listComercial;
    }

    @Override
    public Optional<Comercial> find(int id) {
        Comercial com = jdbcTemplate.queryForObject("SELECT * FROM comercial WHERE id = ?",
                (rs, rowNum) -> new Comercial(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getBigDecimal("comisión"))
                , id
        );

        if (com != null) {
            return Optional.of(com);
        } else {
            log.info("Comercial no encontrado");
            return Optional.empty();
        }
    }

    @Override
    public void update(Comercial comercial) {
        int rows = jdbcTemplate.update("""
                        	UPDATE comercial SET 
                        	                   nombre = ?,
                        	                   apellido1 = ?,
                        	                   apellido2 = ?,
                        	                   comisión = ?
                        	WHERE id = ?                   
                        """, comercial.getNombre(),
                comercial.getApellido1(),
                comercial.getApellido2(),
                comercial.getComision(),
                comercial.getId());

        log.info("Actualizados {} en Comercial", rows);
    }

    @Override
    public void delete(long id) {
        int rows = jdbcTemplate.update("DELETE FROM comercial WHERE id = ?", id);

        log.info("Eliminado {}", rows);
    }

}
