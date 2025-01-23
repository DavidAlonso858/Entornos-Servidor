package org.iesbelen.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteDAO clienteDAO;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired


    public List<Cliente> listAll() {

        return clienteDAO.getAll();

    }

    public Cliente findById(int id) {
        Optional<Cliente> optClie = clienteDAO.find(id);

        if (optClie.isPresent()) {
            return optClie.get();
        } else {
            return null;
        }
    }

    public void newCliente(Cliente cliente) {

        clienteDAO.create(cliente);
    }

    public void update(Cliente cliente) {
        clienteDAO.update(cliente);
    }

    public void delete(long id) {
        clienteDAO.delete(id);
    }
}
