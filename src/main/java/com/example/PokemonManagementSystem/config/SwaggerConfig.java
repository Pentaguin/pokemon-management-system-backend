package com.example.PokemonManagementSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI MusiQOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.addServersItem(new Server().url("http://localhost:8080/api/").description("Localhost)"));
        return openAPI
                .info(new Info().title("Pokemon Management System")
                        .description("Pokemon Management System")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://quintor.nl")));
    }
}


