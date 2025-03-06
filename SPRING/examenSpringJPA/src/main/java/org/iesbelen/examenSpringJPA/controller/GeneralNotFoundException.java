package org.iesbelen.examenSpringJPA.controller;

import org.iesbelen.examenSpringJPA.exception.ProductoNotFundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralNotFoundException {

    @ResponseBody
    @ExceptionHandler(ProductoNotFundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productoNotFund(ProductoNotFundException ex) {
        return ex.getMessage();
    }

}
