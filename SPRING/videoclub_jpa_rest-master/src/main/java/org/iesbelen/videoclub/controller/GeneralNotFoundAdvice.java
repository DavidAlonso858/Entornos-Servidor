package org.iesbelen.videoclub.controller;

import org.iesbelen.videoclub.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PeliculaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String peliculaNotFoundHandler(PeliculaNotFoundException peliculaNotFoundException) {
        return peliculaNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CategoriaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categooriaNotFoundHandler(CategoriaNotFoundException categoriaNotFoundException) {
        return categoriaNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IdiomaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String idiomaNotFoundHandler(IdiomaNotFoundException idiomaNotFoundException) {
        return idiomaNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SocioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String socioNotFoundHandler(SocioNotFoundException socioNotFoundException) {
        return socioNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TarjetaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tarjetaNotFoundHandler(TarjetaNotFoundException tarjetaNotFoundException) {
        return tarjetaNotFoundException.getMessage();
    }
}
