package com.staff.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.staff.management.Staff;

@Controller
public class NewStaffController {
	@GetMapping("/newStaff")
	public String newStaffForm(Model model) {
		model.addAttribute("staff", new Staff());
		return "newStaff";
	}

	@PostMapping("/newStaff")
	public String newStaffSubmit(@ModelAttribute Staff staff, Model model) {
		model.addAttribute("newStaff", staff);
		return "newStaffResult";
	}
}
