package com.carob.empleados.api.repository;

import com.carob.empleados.api.domain.Empleado;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByLegajo(String legajo);

}
