package com.carob.empleados.api.repository;

import com.carob.empleados.api.domain.Sucursal;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SucursalRepository {

    @Resource(name = "jdbcTemplateOperations")
    private JdbcTemplate jdbcTemplate;

    public Optional<Sucursal> findByCodigo(String codigo) {
        try {
            Sucursal sucursal = (Sucursal) jdbcTemplate
                    .queryForObject("SELECT * FROM sucursal WITH (NOLOCK) WHERE codigo = ?", 
                            new Object[]{codigo}, 
                            new BeanPropertyRowMapper(Sucursal.class));
            return Optional.of(sucursal);
        } catch (EmptyResultDataAccessException exc) {
            return Optional.empty();
        }
    }

}
