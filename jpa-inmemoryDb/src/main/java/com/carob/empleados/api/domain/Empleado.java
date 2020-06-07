package com.carob.empleados.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Empleado {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String legajo;
    private String sucursal;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;

}
