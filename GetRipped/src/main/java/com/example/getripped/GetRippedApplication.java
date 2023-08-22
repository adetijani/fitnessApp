package com.example.getripped;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class GetRippedApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetRippedApplication.class, args);
    }

}
