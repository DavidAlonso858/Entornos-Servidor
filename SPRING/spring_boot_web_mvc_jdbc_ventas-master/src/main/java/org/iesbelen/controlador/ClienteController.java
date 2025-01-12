package org.iesbelen.controlador;

import java.util.List;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes";

    }

    @GetMapping("/") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String init(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes";

    }
}