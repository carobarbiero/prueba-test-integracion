package com.carob.empleados.api;

import com.carob.empleados.api.configuration.TestContainerContextInitializer;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(initializers = TestContainerContextInitializer.class)
public class ApplicationTests {

    @Resource(name = "jdbcTemplateConfigurations")
    protected JdbcTemplate jdbcTemplateConfigurations;
    
    @Resource(name = "jdbcTemplateOperations")
    protected JdbcTemplate jdbcTemplateOperations;

    @Test
    public void contextLoads() {
    }
}
