package com.swastikairhub.SwastiKAirHubBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@SpringBootApplication
public class SwastiKAirHubBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwastiKAirHubBackendApplication.class, args);
	}

}
