package com.example.PokemonManagementSystem;

import com.example.PokemonManagementSystem.utl.ColorLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonManagementSystemApplication.class, args);
		ColorLogger.logInfo("Swagger url: http://localhost:8080/api/swagger-ui/index.html");

	}

}
