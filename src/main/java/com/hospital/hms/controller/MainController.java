package com.hospital.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	     
	       
	
	@GetMapping("/main")
	public String main() {   
		System.out.println("Inside Main ");
		return "Main/main";
	}
 
	@GetMapping("/patientmain")
	public String patientmain() {
		System.out.println("Inside patient  Main ");
		return "Patient/patientMain";
	}
 
	@GetMapping("/doctormain")
	public String doctormain() {
		System.out.println("Inside doctor  Main ");
		return "Doctor/doctorMain";
	}
	
	@GetMapping("/feedbackmain")
	public String feedbackrmain() {
		System.out.println("Inside feedback  Main ");
		return "Feedback/feedbackMain";
	}
	
	@GetMapping("/appointmentmain")
	public String appointmentrmain() {
		System.out.println("Inside feedback  Main ");
		return "Appointment/appointmentMain";
	}
} 
