package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.excepcion.MiExcepcion;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ClienteService;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ComercialService comercialService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación

    @GetMapping("/clientes")
    //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes/clientes";

    }

    @GetMapping("/clientes/{id}")
    public String detalle(Model model, @PathVariable int id) {
        Cliente cli = clienteService.findById(id);

        model.addAttribute("cliente", cli);

        return "clientes/detalle-cliente";
    }

    @GetMapping("/clientes/crear")
    public String crear(Model model) {
        Cliente cli = new Cliente();
        List<Comercial> listaComercial = comercialService.listAll();

        model.addAttribute("cliente", cli);
        model.addAttribute("listaComercial", listaComercial);

        return "clientes/crear-cliente";
    }

    @PostMapping("clientes/crear")
    public String crear(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {

        // si tiene errores se queda en la vista de crear
        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "clientes/crear-cliente";
        }

        clienteService.newCliente(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Cliente cli = clienteService.findById(id);

        model.addAttribute("cliente", cli);

        return "clientes/editar-cliente";
    }

    @PostMapping("clientes/editar/{id}")
    public String editar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "clientes/editar-cliente";
        }

        clienteService.update(cliente);

        return "redirect:/clientes";
    }

    @PostMapping("clientes/borrar/{id}")
    public String borrar(@PathVariable long id) {

        clienteService.delete(id);

        return "redirect:/clientes";
    }

    // Simula una MiExcepcion al acceder a esta ruta

    @GetMapping("/error-custom")
    public String lanzarMiExcepcion() throws MiExcepcion {
        throw new MiExcepcion("¡excepción personalizada!");
    }

    @GetMapping("/error-runtime")
    public String lanzarRuntimeException() {
        throw new RuntimeException("¡Ocurrió un error inesperado!");
    }

}