package com.application.ResolveX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class ResolveXApplication {

	public static void main(String[] args) {

		SpringApplication.run(ResolveXApplication.class, args);
	}

}
