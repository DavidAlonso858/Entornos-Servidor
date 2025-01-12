package org.iesbelen.prueba.Controlador;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class HelloController {

    @GetMapping("/app/foo")
    public Map<String, String> foo() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("mesanje", "Hola mundo prueba de spring");

        return mapa;
    }
}
