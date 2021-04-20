package com.staff.management;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff {
	private String firstName;
	private String lastName;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	private Date endDate;
	private String position;
	private String department;
	private String deskLocation;
	private String managerEmail;
	private Boolean academicStaff;
	private Boolean professionalStaff;
}
