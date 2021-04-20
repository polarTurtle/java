package com.sampleCache.firstcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sampleCache")
public class FirstCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstCacheApplication.class, args);
	}

}
