package com.example.springjpa.controller;

import com.example.springjpa.model.Empleado;
import com.example.springjpa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({"/", ""})
    public List<Empleado> empledos() {

        return empleadoService.findAll();
    }

    @GetMapping("/crear")
    public Empleado crear() {
        Empleado emp = new Empleado();
        emp.setNombre("David");
        emp.setApellido("Garcia");

        return empleadoService.guardarEmpleado(emp);
    }
}
