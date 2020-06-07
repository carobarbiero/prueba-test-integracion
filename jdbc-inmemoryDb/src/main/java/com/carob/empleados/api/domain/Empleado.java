package com.carob.empleados.api.domain;

import lombok.Data;

@Data
public class Empleado {

    private Long id;
    private String legajo;
    private String sucursal;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;

}
