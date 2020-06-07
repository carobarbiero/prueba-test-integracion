package com.carob.empleados.api.repository;

import com.carob.empleados.api.domain.Empleado;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<Empleado> findByLegajo(String legajo) {
        try {
            Empleado empleado = (Empleado) jdbcTemplate
                    .queryForObject("SELECT * FROM empleado WITH (NOLOCK) WHERE legajo = ?", 
                            new Object[]{legajo}, 
                            new BeanPropertyRowMapper(Empleado.class));
            return Optional.of(empleado);
        } catch (EmptyResultDataAccessException exc) {
            return Optional.empty();
        }
    }

}
