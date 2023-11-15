package com.codeinvestigator.multiple_datasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties

public class MultipleDatasourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatasourcesApplication.class, args);
    }

}
