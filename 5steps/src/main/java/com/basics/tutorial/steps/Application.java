package com.basics.tutorial.steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.basics.tutorial.steps.scope.PersonDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		
		System.out.println("fixed?");
		

	}

}
