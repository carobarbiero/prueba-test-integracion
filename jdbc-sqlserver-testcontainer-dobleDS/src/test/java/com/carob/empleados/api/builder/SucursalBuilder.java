package com.carob.empleados.api.builder;

import com.carob.empleados.api.domain.Sucursal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class SucursalBuilder {

    private final Sucursal instance;
    private static int numeroCodigoInicial = 569;

    public SucursalBuilder() {
        this.instance = new Sucursal();
        this.instance.setCodigo(String.valueOf(numeroCodigoInicial));
        this.instance.setDescripcion("Sucursal Parque Patricios");
        numeroCodigoInicial++;
    }

    public static SucursalBuilder tipica() {
        SucursalBuilder builder = new SucursalBuilder();
        return builder;
    }
    
    public Sucursal build(JdbcTemplate jdbcTemplate) {
        Long idSucursal = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("sucursal")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(getCamposMap())
                .longValue();
        instance.setId(idSucursal);
        return instance;
    }

    private Map<String, Object> getCamposMap() {
        Map<String, Object> camposMap = new HashMap<>();
        camposMap.put("codigo", instance.getCodigo());
        camposMap.put("descripcion", instance.getDescripcion());
        return camposMap;
    }
}
