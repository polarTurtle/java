package com.staff.onboarding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.staff.onboarding.formSubmissions.NewStaff;

@Controller
public class NewStaffController {
	@GetMapping("/newStaff")
	public String newStaffForm(Model model) {
		model.addAttribute("newStaff", new NewStaff());
		return "newStaff";
	}

	@PostMapping("/newStaff")
	public String newStaffSubmit(@ModelAttribute NewStaff newStaff, Model model) {
		model.addAttribute("newStaff", newStaff);
		return "result";
	}
}
