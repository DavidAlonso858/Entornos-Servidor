package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Tarjeta;
import org.iesbelen.videoclub.exception.TarjetaNotFoundException;
import org.iesbelen.videoclub.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public List<Tarjeta> findAll() {
        return this.tarjetaRepository.findAll();
    }

    public Tarjeta findById(Long id) {
        return this.tarjetaRepository.findById(id)
                .orElseThrow(() -> new TarjetaNotFoundException(id));
    }

    public Tarjeta create(Tarjeta tarjeta) {
        return this.tarjetaRepository.save(tarjeta);
    }

    public Tarjeta replace(Tarjeta tarjeta, Long id) {
        return this.tarjetaRepository.findById(id).map(t -> (id.equals(t.getId()) ?
                        this.tarjetaRepository.save(tarjeta) : null))
                .orElseThrow(() -> new TarjetaNotFoundException(id));
    }

    public void delete(Long id) {
        this.tarjetaRepository.findById(id).map(t -> {
            this.tarjetaRepository.delete(t);
            return t;
        }).orElseThrow(() -> new TarjetaNotFoundException(id));
    }
}
