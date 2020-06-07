package com.carob.empleados.api.service;

import com.carob.empleados.api.ApplicationTests;
import com.carob.empleados.api.builder.EmpleadoBuilder;
import com.carob.empleados.api.domain.Empleado;
import com.carob.empleados.api.exception.NotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoServiceTest extends ApplicationTests {

    @Autowired
    private EmpleadoService empleadoService;

    @Test
    public void buscarPorLegajo_conLegajoExistente_retornaEmpleado() throws Exception {
        final long startTime = System.currentTimeMillis();
        Empleado empleado = EmpleadoBuilder.tipico().build(jdbcTemplate);

        Empleado empleadoEncontrado = empleadoService.buscarPorLegajo(empleado.getLegajo());

        assertThat(empleadoEncontrado).isEqualTo(empleado);
        final long endTime = System.currentTimeMillis();
        System.out.println("*".repeat(100) + " Total execution time: " + (endTime - startTime));
    }

    @Test
    public void buscarPorLegajo_conLegajoInexistente_lanzaEmpleadosApiExcepcion() throws Exception {
        assertThatThrownBy(() -> empleadoService.buscarPorLegajo("INEXISTENTE"))
                .isInstanceOf(NotFoundException.class);
    }

}
