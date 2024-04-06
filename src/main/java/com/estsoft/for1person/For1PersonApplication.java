package com.estsoft.for1person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class For1PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(For1PersonApplication.class, args);
	}

}
