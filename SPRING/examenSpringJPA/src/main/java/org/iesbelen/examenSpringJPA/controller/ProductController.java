package org.iesbelen.examenSpringJPA.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.examenSpringJPA.domain.Product;
import org.iesbelen.examenSpringJPA.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/producto")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // OBTENER
    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamanio", "!orden"})
    public List<Product> getAllProducts() {
        log.info("Todos los productos obtenidos");
        return productService.findAll();
    }

    @GetMapping(value = {"", "/"}, params = {"!orden"})
    public Map<String, Object> getProductsByPage(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                 @RequestParam(value = "tamanio", defaultValue = "1") int tamanio) {

        Map<String, Object> mapilla = this.productService.paginado(pagina, tamanio);

        return mapilla;
    }

    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamanio"})
    public List<Product> ordenado(@RequestParam(value = "orden") Optional<String[]> orden) {
        return this.productService.ordenado(orden);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        log.info("Producto obtenido");
        return this.productService.one(id);
    }

    // CREAR
    @PostMapping(value = {"", "/"})
    public Product addProduct(@RequestBody Product product) {
        log.info("Producto agregado");
        return this.productService.save(product);
    }

    //ACTUALIZAR
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        log.info("Producto actualizado");
        return this.productService.replace(id, product);
    }

    // BORRAR
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void borrado(@PathVariable Long id) {
        log.info("Producto eliminado");
        this.productService.delete(id);
    }
}
