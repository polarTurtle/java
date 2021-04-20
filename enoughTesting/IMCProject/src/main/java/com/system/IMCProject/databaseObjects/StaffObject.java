package com.system.IMCProject.databaseObjects;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.system.IMCProject.views.StaffView;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StaffObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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


	public StaffObject(StaffView view) {
		firstName = view.getFirstName();
		lastName = view.getLastName();
		startDate = view.getStartDate();
		endDate = view.getEndDate();
		position = view.getPosition();
		department = view.getDepartment();
		location = view.getLocation();
		email = view.getEmail();
		moodleAccess = view.isMoodleAccess();
		zoomAccess = view.isZoomAccess();
		portalAccess = view.isPortalAccess();
		officeAccess = view.isOfficeAccess();
		managerEmail = view.getManagerEmail();
	}

}
