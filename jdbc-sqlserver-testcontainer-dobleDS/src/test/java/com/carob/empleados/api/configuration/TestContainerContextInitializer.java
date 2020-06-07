package com.carob.empleados.api.configuration;

import static com.carob.empleados.api.configuration.AbstractTestContainers.SQLSERVER_CONTAINER;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class TestContainerContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        TestPropertyValues.of(
                "datasource.configurations.jdbcUrl=" + SQLSERVER_CONTAINER.getJdbcUrl() + ";databaseName=Configurations",
                "datasource.configurations.username=" + SQLSERVER_CONTAINER.getUsername(),
                "datasource.configurations.password=" + SQLSERVER_CONTAINER.getPassword(),
                "datasource.configurations.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver",
                "datasource.operations.jdbcUrl=" + SQLSERVER_CONTAINER.getJdbcUrl() + ";databaseName=Operations",
                "datasource.operations.username=" + SQLSERVER_CONTAINER.getUsername(),
                "datasource.operations.password=" + SQLSERVER_CONTAINER.getPassword(),
                "datasource.operations.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver"
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
