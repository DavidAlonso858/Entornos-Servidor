package org.iesbelen.dao;

import java.util.List;
import java.util.Optional;

public interface Usuario {
    public void create(Usuario Usuario);

    public List<Usuario> getAll();

    public Optional<Usuario> find(int idUsuario);

    public void update(Usuario usuario);

    public void delete(int id);

    public Optional<Usuario> findLogin(String usuario);

}
