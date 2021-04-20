package com.system.IMCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.system.IMCProject.databaseObjects.StaffObject;

@Component
public class EmailServiceIMPL {

	@Autowired
	private JavaMailSender emailSender;

	public void sendTestMessage() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("roy.shen@imc.edu.au");
				message.setTo("roy.shen@top.edu.au");
				message.setSubject("test subject");
				message.setText("test text");
				emailSender.send(message);
			}

		});
		t.start();
	}

	public void newStaffTestMessage(StaffObject staff) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("roy.shen@imc.edu.au");
				message.setTo("roy.shen@top.edu.au");
				message.setSubject("New Staff: " + staff);
				message.setText("Staff member " + staff.getFirstName() + " " + staff.getLastName()
						+ " has been imported into the database");
				emailSender.send(message);
				System.out.println("New staff: " + staff.toString());
			}
		});
		t.start();
	}

}
