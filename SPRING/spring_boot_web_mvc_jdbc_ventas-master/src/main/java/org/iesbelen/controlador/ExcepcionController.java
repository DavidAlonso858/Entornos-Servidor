package org.iesbelen.controlador;

import org.iesbelen.excepcion.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@ControllerAdvice // clase global para manejar excepciones en cualquier controlador del proyecto
public class ExcepcionController {

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException e) {
        model.addAttribute("mensaje", e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }

    @ExceptionHandler(MiExcepcion.class) // le paso la clase que he hecho como excepcion personalizada
    public String handleMiException(Model model, MiExcepcion e) {
        model.addAttribute("mensaje", e.getMessage());
        return "error-mi-excepcion";
    }
}