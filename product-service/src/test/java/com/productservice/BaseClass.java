package com.productservice;

import org.mockito.Mock;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClass {

    @Container
    static     MySQLContainer mySQLContainer  = new MySQLContainer("mysql:latest")
            .withDatabaseName("aspring-testdb")
            .withUsername("root")
            .withPassword("root");


    static {
        mySQLContainer.start();
    }


    @Bean
    public ObjectMapper get(){
        return  new ObjectMapper();
    }

}
