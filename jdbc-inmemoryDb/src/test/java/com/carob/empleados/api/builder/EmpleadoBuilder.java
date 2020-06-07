package com.carob.empleados.api.builder;

import com.carob.empleados.api.domain.Empleado;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class EmpleadoBuilder {

    private final Empleado instance;
    private static int numeroLegajoInicial = 1000;

    public EmpleadoBuilder() {
        this.instance = new Empleado();
        this.instance.setLegajo("A" + String.valueOf(numeroLegajoInicial));
        this.instance.setNombre("Juan");
        this.instance.setApellido("Perez");
        this.instance.setSucursal("569");
        this.instance.setNumeroDocumento("12345678");
        this.instance.setTipoDocumento("D");
        numeroLegajoInicial++;
    }

    public static EmpleadoBuilder tipico() {
        EmpleadoBuilder builder = new EmpleadoBuilder();
        return builder;
    }

    public EmpleadoBuilder conNombre(String nombre) {
        this.instance.setNombre(nombre);
        return this;
    }
    
    public Empleado build(JdbcTemplate jdbcTemplate) {
        Long idEmpleado = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("empleado")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(getCamposMap())
                .longValue();
        instance.setId(idEmpleado);
        return instance;
    }

    private Map<String, Object> getCamposMap() {
        Map<String, Object> camposMap = new HashMap<>();
        camposMap.put("legajo", instance.getLegajo());
        camposMap.put("sucursal", instance.getSucursal());
        camposMap.put("nombre", instance.getNombre());
        camposMap.put("apellido", instance.getApellido());
        camposMap.put("tipo_documento", instance.getTipoDocumento());
        camposMap.put("numero_documento", instance.getNumeroDocumento());
        return camposMap;
    }
}
