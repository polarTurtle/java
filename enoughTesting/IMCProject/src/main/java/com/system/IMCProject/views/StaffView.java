package com.system.IMCProject.views;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffView {

	private String firstName;
	private String lastName;
	private Date startDate;
	private Date endDate;
	private String position;
	private String department;
	private String location;
	private String email;
	private boolean moodleAccess;
	private boolean zoomAccess;
	private boolean portalAccess;
	private boolean officeAccess;
	private String managerEmail;

}
