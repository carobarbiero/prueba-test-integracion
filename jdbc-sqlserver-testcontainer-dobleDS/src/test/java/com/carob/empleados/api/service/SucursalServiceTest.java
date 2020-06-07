package com.carob.empleados.api.service;

import com.carob.empleados.api.ApplicationTests;
import com.carob.empleados.api.builder.SucursalBuilder;
import com.carob.empleados.api.domain.Sucursal;
import com.carob.empleados.api.exception.NotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SucursalServiceTest extends ApplicationTests {

    @Autowired
    private SucursalService sucursalService;

    @Test
    public void buscarPorCodigo_conCodigoExistente_retornaSucursal() throws Exception {
        final long startTime = System.currentTimeMillis();
        Sucursal sucursal = SucursalBuilder.tipica().build(jdbcTemplateOperations);

        Sucursal sucursalEncontrada = sucursalService.buscarPorCodigo(sucursal.getCodigo());

        assertThat(sucursalEncontrada).isEqualTo(sucursal);
        final long endTime = System.currentTimeMillis();
        System.out.println("*".repeat(100) + " Total execution time: " + (endTime - startTime));
    }

    @Test
    public void buscarPorCodigo_conCodigoInexistente_lanzaNotFoundExcepcion() throws Exception {
        assertThatThrownBy(() -> sucursalService.buscarPorCodigo("INEXISTENTE"))
                .isInstanceOf(NotFoundException.class);
    }

}
