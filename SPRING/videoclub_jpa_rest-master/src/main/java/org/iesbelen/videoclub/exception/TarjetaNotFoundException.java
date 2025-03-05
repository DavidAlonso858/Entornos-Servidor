package org.iesbelen.videoclub.exception;

public class TarjetaNotFoundException extends RuntimeException {
    public TarjetaNotFoundException(Long id) {
        super("Tarjeta no encontrada: " + id);
    }
}
