package com.carob.empleados.api.service;

import com.carob.empleados.api.domain.Empleado;
import com.carob.empleados.api.exception.NotFoundException;
import com.carob.empleados.api.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado buscarPorLegajo(String legajo) {
        return empleadoRepository.findByLegajo(legajo)
                .orElseThrow(() -> new NotFoundException("No se encontro el empleado con el legajo " + legajo));
    }

}
