package com.basics.tutorial.steps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.basics.tutorial.steps.basic.BinarySearchImpl;

@Configuration
@ComponentScan
public class BasicApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicApplication.class);
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);

		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		
		int result = 
				binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
		//applicationContext.close();
	}

}