package org.iesbelen.dao;

import org.iesbelen.model.Empleados;

import java.util.List;
import java.util.Optional;

public interface EmpleadosDAO {

    public void create(Empleados emp);

    public List<Empleados> getAll();

    public Optional<Empleados> find(int id);

    public void update(Empleados emp);

    public void delete(int id);

}
