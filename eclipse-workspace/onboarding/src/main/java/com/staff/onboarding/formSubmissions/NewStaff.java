package com.staff.onboarding.formSubmissions;

import java.util.Date;

public class NewStaff {
	// general information
	private String firstName;
	private String lastName;
	private Date startDate;
	private Date endDate;
	private String position;
	private String department;
	private String deskLocation;
	private String managerEmail;
	private Boolean academicStaff;
	private Boolean professionalStaff;


	// System access


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDeskLocation() {
		return deskLocation;
	}

	public void setDeskLocation(String deskLocation) {
		this.deskLocation = deskLocation;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public Boolean getAcademicStaff() {
		return academicStaff;
	}

	public void setAcademicStaff(Boolean academicStaff) {
		this.academicStaff = academicStaff;
	}

	public Boolean getProfessionalStaff() {
		return professionalStaff;
	}

	public void setProfessionalStaff(Boolean professionalStaff) {
		this.professionalStaff = professionalStaff;
	}
	
	
}
