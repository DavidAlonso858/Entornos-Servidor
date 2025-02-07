package org.iesbelen.service;

import org.iesbelen.domain.Idioma;
import org.iesbelen.repository.IdiomaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaDAO idiomaDAO;

    public List<Idioma> getAllIdioma() {
        return idiomaDAO.listIdioma();
    }
}
