package com.basics.tutorial.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.basics.tutorial.componentscan.ComponentPersonDAO;

@Component
@ComponentScan("com.basics.tutorial.componentscan")
public class ApplicationScopeComponent {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationScopeComponent.class);

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationScopeComponent.class);
		
		
		ComponentPersonDAO personDAO = applicationContext.getBean(ComponentPersonDAO.class);
		
		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		
		System.out.println("test");

		
	}

}
