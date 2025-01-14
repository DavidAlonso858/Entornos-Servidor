package org.iesbelen.dao;

import org.iesbelen.model.Departamentos;

import java.util.List;
import java.util.Optional;

public interface DepartamentosDAO {
    public void create(Departamentos departamento);

    public List<Departamentos> getAll();

    public Optional<Departamentos> find(int id);

    public void update(Departamentos departamento);

    public void delete(int id);

}
