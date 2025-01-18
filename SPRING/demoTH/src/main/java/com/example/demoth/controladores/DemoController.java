package com.example.demoth.controladores;

import com.example.demoth.modelos.Libro;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/demo")
    public String Prueba(Model model) {
        String parrafo = "Prueba David";

        model.addAttribute("parrafo", parrafo);

        return "vistaPrueba";
    }

    @GetMapping("/demo2")
    public String PruebaLista(Model model) {
        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro(1, "El Quijote", "Miguel Cervantes"));
        libros.add(new Libro(2, "Crimen y Castigo", "Fedor Dostoiesvski"));
        libros.add(new Libro(3, "El Extranjero", "Albert Camus"));

        model.addAttribute(libros);
        return "vistaPrueba";
    }

    @GetMapping("/demo3")
    public String demoth3(Model model, HttpSession session) {

        String variable = "Hola, mundo!";

        model.addAttribute("variable", variable);

        String variableSesion = "Esto es una variable de sesión...";

        session.setAttribute("unaVariableDeSesion", variableSesion);

        Libro libro = new Libro(3, "El Extranjero", "Albert Camus");
        session.setAttribute("Extranjero", libro);

        return "vistaPrueba";
    }

    @GetMapping("/demo4")
    public String demoth4(Model model) {

        Libro libro = new Libro(2, "Crimen y Castigo", "Fedor Dostoiesvski");

        model.addAttribute("libro", libro);

        return "vistaPrueba";
    }

    @GetMapping("/demo5")
    public String demoth5(Model model) {
        Libro libro = new Libro(3, "El Extranjero", "Albert Camus");
        model.addAttribute("libro", libro);

        return "demo5";
    }

    @GetMapping("/demo6")
    public String demoth6(Model model) {

        Libro libro = new Libro(2, "Crimen y Castigo", "Fedor Dostoiesvski");

        model.addAttribute("libro", libro);

        return "demo6";
    }

    @GetMapping("/demo7")
    public String demoth7(Model model) {

        return "demo7";
    }

}
