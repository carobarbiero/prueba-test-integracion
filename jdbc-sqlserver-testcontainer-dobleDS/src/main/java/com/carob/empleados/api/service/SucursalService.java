package com.carob.empleados.api.service;

import com.carob.empleados.api.domain.Sucursal;
import com.carob.empleados.api.exception.NotFoundException;
import com.carob.empleados.api.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal buscarPorCodigo(String codigo) {
        return sucursalRepository.findByCodigo(codigo)
                .orElseThrow(() -> new NotFoundException("No se encontro la sucursal con el codigo " + codigo));
    }

}
