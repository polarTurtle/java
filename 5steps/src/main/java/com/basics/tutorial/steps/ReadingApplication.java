package com.basics.tutorial.steps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.basics.tutorial.steps.properties.SomeExternalService;

@Component
@ComponentScan
@PropertySource("classpath:app.properties")
public class ReadingApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ReadingApplication.class);
		
		SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);
		
		System.out.println(someExternalService);
		applicationContext.close();
	}

}