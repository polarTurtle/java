package com.system.IMCProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.system.IMCProject.repository")
public class ImcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImcProjectApplication.class, args);
	}

}
