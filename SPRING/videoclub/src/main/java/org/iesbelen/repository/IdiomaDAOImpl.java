package org.iesbelen.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class IdiomaDAOImpl implements IdiomaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Idioma> listIdioma() {
        List<Idioma> listIdioma = jdbcTemplate.query(
                "SELECT id_idioma, nombre FROM idioma",
                (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"),
                        rs.getString("nombre")
                )
        );

        log.info("Devueltos {} registros.", listIdioma.size());

        return listIdioma;
    }
}
