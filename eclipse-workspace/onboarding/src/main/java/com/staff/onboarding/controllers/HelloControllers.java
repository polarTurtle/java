package com.staff.onboarding.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllers {
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
