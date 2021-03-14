package com.basics.tutorial.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.basics.tutorial.steps.scope.PersonDAO;


@Component
@ComponentScan
@PropertySource("classpath:app.properties")
public class ApplicationScope {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationScope.class);

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(ApplicationScope.class, args);
		
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		
		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());
		
		System.out.println("test");
		
	}

}
