package org.iesbelen.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Categoria> find(int id_categoria) {

        Categoria cat = jdbcTemplate
                .queryForObject("SELECT id_categoria, nombre FROM categoria WHERE id_categoria = ?"
                        , (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                                rs.getString("nombre"))
                        , id_categoria
                );

        if (cat != null) {
            return Optional.of(cat);
        } else {
            log.info("Categoria no encontrada.");
            return Optional.empty();
        }

    }
}
