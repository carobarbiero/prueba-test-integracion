package com.carob.empleados.api.builder;

import com.carob.empleados.api.domain.Empleado;
import javax.persistence.EntityManager;

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

    public Empleado build() {
        return instance;
    }

    public Empleado build(EntityManager em) {
        em.persist(instance);
        em.flush();
        em.detach(instance);
        return instance;
    }
}
