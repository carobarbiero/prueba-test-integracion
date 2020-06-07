package com.carob.empleados.api.configuration;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.MSSQLServerContainer;

@Slf4j
public abstract class AbstractTestContainers {

    public static final MSSQLServerContainer SQLSERVER_CONTAINER;

    static {
        SQLSERVER_CONTAINER = (MSSQLServerContainer) new MSSQLServerContainer()
                .withInitScript("schema.sql");
        SQLSERVER_CONTAINER.start();
    }
}
