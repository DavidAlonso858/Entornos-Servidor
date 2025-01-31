package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapping.PedidoMapper;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.iesbelen.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/comercial")
    public String listar(Model model) {
        List<Comercial> listaComercial = comercialService.listAll();


        model.addAttribute("listaComercial", listaComercial);

        return "comerciales/comerciales";
    }

    @GetMapping("/comercial/{id}")
    public String detalle(Model model, @PathVariable int id) {
        Comercial com = comercialService.findById(id);
        List<PedidoDTO> pedidoDTOS = pedidoService.listPedidosDTO(id);
        int total = pedidoService.conteoTodos();

        double media = pedidoService.mediaPedidos(total, pedidoDTOS.size());

        model.addAttribute("comercial", com);
        model.addAttribute("listaPedidos", pedidoDTOS);
        model.addAttribute("totalPedidos", total);
        model.addAttribute("media", media);

        return "comerciales/detalle-comercial";
    }

    @GetMapping("/comercial/crear")
    public String crear(Model model) {
        Comercial comercial = new Comercial();


        model.addAttribute("comercial", comercial);

        return "comerciales/crear-comercial";
    }

    @PostMapping("/comercial/crear")
    public String crear(@Valid @ModelAttribute Comercial comercial, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("comercial", comercial);
            return "comerciales/crear-comercial";

        }

        comercialService.newComercial(comercial);

        return "redirect:/comercial";
    }


    @GetMapping("/comercial/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Comercial comercial = comercialService.findById(id);

        model.addAttribute("comercial", comercial);

        return "comerciales/editar-comercial";
    }

    @PostMapping("comercial/editar/{id}")
    public String editar(@ModelAttribute("comercial") Comercial co) {

        comercialService.update(co);

        return "redirect:/comercial";
    }

    @PostMapping("comercial/borrar/{id}")
    public String borrar(@PathVariable int id) {

        comercialService.delete(id);

        return "redirect:/comercial";
    }
}
