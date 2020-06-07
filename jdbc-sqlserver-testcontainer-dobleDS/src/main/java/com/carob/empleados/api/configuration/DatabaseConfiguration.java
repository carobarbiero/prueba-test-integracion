package com.carob.empleados.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements TransactionManagementConfigurer {

    @Bean(name = "dataSourceConfigurations")
    @Primary
    @ConfigurationProperties(prefix = "datasource.configurations")
    public DataSource configurationsDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcTemplateConfigurations")
    @Autowired
    public JdbcTemplate jdbcTemplateConfigurations(@Qualifier("dataSourceConfigurations") DataSource dataSourceConfigurations) {
        JdbcTemplate jdbcTemplateConfigurations = new JdbcTemplate(dataSourceConfigurations);
        return jdbcTemplateConfigurations;
    }

    @Bean(name = "dataSourceOperations")
    @ConfigurationProperties(prefix = "datasource.operations")
    public DataSource operationsDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcTemplateOperations")
    @Autowired
    public JdbcTemplate jdbcTemplateOperations(@Qualifier("dataSourceOperations") DataSource dataSourceOperations) {
        JdbcTemplate jdbcTemplateOperations = new JdbcTemplate(dataSourceOperations);
        return jdbcTemplateOperations;
    }

    @Bean
    public PlatformTransactionManager configurationsTxManager() {
        return new DataSourceTransactionManager(configurationsDataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return configurationsTxManager();
    }
}
