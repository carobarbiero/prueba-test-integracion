package com.carob.empleados.api.controller.rest;

import com.carob.empleados.api.ApplicationTests;
import com.carob.empleados.api.builder.SucursalBuilder;
import com.carob.empleados.api.domain.Sucursal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class SucursalRestControllerTest extends ApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void buscarPorCodigo() throws Exception {
        Sucursal sucursal = SucursalBuilder.tipica().build(jdbcTemplateOperations);

        mockMvc
                .perform(get("/sucursales/{codigo}", sucursal.getCodigo())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.codigo", is(sucursal.getCodigo())));
    }

    @Test
    public void buscarPorCodigo_sucursalInexistente() throws Exception {
        mockMvc
                .perform(get("/sucursales/INEXISTENTE")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
