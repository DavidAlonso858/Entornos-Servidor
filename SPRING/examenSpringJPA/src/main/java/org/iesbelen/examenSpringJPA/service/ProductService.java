package org.iesbelen.examenSpringJPA.service;

import org.iesbelen.examenSpringJPA.domain.Product;
import org.iesbelen.examenSpringJPA.exception.ProductoNotFundException;
import org.iesbelen.examenSpringJPA.repository.ProductCustomRepository;
import org.iesbelen.examenSpringJPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductCustomRepository productCustomRepository;

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product one(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductoNotFundException(id));
    }

    public Product save(Product product) {

        return this.productRepository.save(product);
    }

    public Product replace(Long id, Product producto) {

        return this.productRepository.findById(id).map(p -> (id.equals(producto.getId()) ?
                        this.productRepository.save(producto) : null))
                .orElseThrow(() -> new ProductoNotFundException(id));

    }

    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    public Map<String, Object> paginado(int pagina, int tamanio) {
        Pageable pag = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());

        Page<Product> products = this.productRepository.findAll(pag);

        Map<String, Object> map = new HashMap<>();

        map.put("productos", products.getContent());
        map.put("total", products.getTotalElements());
        map.put("totalElements", products.getTotalElements());
        map.put("totalPages", products.getTotalPages());

        return map;
    }

    public List<Product> ordenado(Optional<String[]> orden) {
        return this.productCustomRepository.ordenado(orden);
    }
}
