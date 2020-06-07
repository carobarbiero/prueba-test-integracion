package com.carob.empleados.api.controller.rest;

import com.carob.empleados.api.domain.Sucursal;
import com.carob.empleados.api.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SucursalRestController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/sucursales/{codigo}")
    public Sucursal buscarPorLegajo(@PathVariable String codigo) {
        return sucursalService.buscarPorCodigo(codigo);
    }

}
