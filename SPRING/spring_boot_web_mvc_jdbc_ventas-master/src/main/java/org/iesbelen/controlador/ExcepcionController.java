package org.iesbelen.controlador;

import org.iesbelen.excepcion.MiExcepcion;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // clase global para manejar excepciones en cualquier controlador del proyecto
public class ExcepcionController {
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException e) {
        ModelAndView mv = new ModelAndView("error");// carga la vista error.html
        mv.addObject("mensaje", e.getMessage());
        // y pasa el mensaje de error como modelo vista para devolverlo
        return mv;
    }

    @ExceptionHandler(MiExcepcion.class) // le paso la clase que he hecho como excepcion personalizada
    public ModelAndView handleMiException(MiExcepcion e) {
        ModelAndView mv = new ModelAndView("error-mi-excepcion");
        mv.addObject("mensaje", e.getMessage());
        return mv;
    }
}