package org.iesbelen.service;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercialService {

    @Autowired
    private ComercialDAO comercialDAO;

    public List<Comercial> listAll() {
        return comercialDAO.getAll();
    }

    public Comercial findById(int id) {
        Optional<Comercial> optCom = comercialDAO.find(id);

        if (optCom.isPresent()) {
            return optCom.get();
        } else {
            return null;
        }
    }

    public void newComercial(Comercial comercial) {
        comercialDAO.create(comercial);
    }

    public void update(Comercial comercial) {
        comercialDAO.update(comercial);
    }

    public void delete(int id) {
        comercialDAO.delete(id);
    }
}
