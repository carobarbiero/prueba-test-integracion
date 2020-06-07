package com.carob.empleados.api.controller.rest;

import com.carob.empleados.api.ApplicationTests;
import com.carob.empleados.api.builder.EmpleadoBuilder;
import com.carob.empleados.api.domain.Empleado;
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
public class EmpleadoRestControllerTest extends ApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void buscarPorLegajo() throws Exception {
        Empleado empleado = EmpleadoBuilder.tipico().build(jdbcTemplateConfigurations);

        mockMvc
                .perform(get("/empleados/{legajo}", empleado.getLegajo())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.legajo", is(empleado.getLegajo())));
    }

    @Test
    public void buscarPorLegajo_empleadoInexistente() throws Exception {
        mockMvc
                .perform(get("/empleados/INEXISTENTE")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
