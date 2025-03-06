package org.iesbelen.examenSpringJPA.exception;

public class ProductoNotFundException extends RuntimeException {
    public ProductoNotFundException(Long id) {
        super("Producto no encontrado: " + id);
    }
}
