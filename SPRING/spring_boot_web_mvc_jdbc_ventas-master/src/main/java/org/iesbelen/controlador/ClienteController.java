package org.iesbelen.controlador;

import java.util.List;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping({"/clientes", "/"})
    //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes";

    }

    @GetMapping("/clientes/{id}")
    public String detalle(Model model, @PathVariable int id) {
        Cliente cli = clienteService.findById(id);

        model.addAttribute("cliente", cli);
        return "detalle-cliente";
    }

    @GetMapping("/clientes/crear")
    public String crear(Model model) {
        Cliente cli = new Cliente();

        model.addAttribute("cliente", cli);

        return "crear-cliente";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Cliente cli = clienteService.findById(id);

        model.addAttribute("cliente", cli);

        return "editar-cliente";
    }

}