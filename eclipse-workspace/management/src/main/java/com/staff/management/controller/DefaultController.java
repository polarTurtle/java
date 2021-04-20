package com.staff.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	@RequestMapping("/")
	public String index() {
		return "A small application for managing new and returning staff, and automating the process of account creation and deletion";
	}
}
