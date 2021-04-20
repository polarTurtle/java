package com.system.IMCProject.controllers;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.IMCProject.EmailServiceIMPL;
import com.system.IMCProject.databaseObjects.StaffObject;
import com.system.IMCProject.repository.StaffRepository;
import com.system.IMCProject.views.StaffView;

@Controller
public class StaffController {

	@Autowired
	StaffRepository staffRepo;

	@Autowired
	EntityManager entityManager;

	@Autowired
	EmailServiceIMPL email;

	@GetMapping("/newStaff")
	public String newStaffForm(Model model) {
		model.addAttribute("staff", new StaffView());
		return "newStaffCreationPage";
	}

	@PostMapping("/newStaff")
	public String submitNewStaff(@ModelAttribute StaffView staff, Model model) {
		model.addAttribute("staff", staff);
		Optional<StaffObject> manager = staffRepo.findByEmail(staff.getManagerEmail());
		System.out.println(manager == null);
		StaffObject staffObject = new StaffObject(staff);
		staffRepo.save(staffObject);
		email.newStaffTestMessage(staffObject);
		return "newStaffSubmission";
	}

	@GetMapping("/existingStaff/{staffEmail}")
	public String existingStaffForm(Model model, @PathVariable String staffEmail) {
		StaffObject existingStaff = staffRepo.findByEmail(staffEmail).orElse(null);
		if (existingStaff == null)
			return "staffNotFound";
		model.addAttribute("staff", existingStaff);
		return "editExistingStaff";
	}

	@PostMapping
	public String submitExistingStaff(@ModelAttribute StaffView staff, Model model)
}
