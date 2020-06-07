package com.carob.empleados.api.controller.rest;

import com.carob.empleados.api.domain.Empleado;
import com.carob.empleados.api.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados/{legajo}")
    public Empleado buscarPorLegajo(@PathVariable String legajo) {
        return empleadoService.buscarPorLegajo(legajo);
    }

}
