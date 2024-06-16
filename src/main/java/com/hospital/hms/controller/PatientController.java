package com.hospital.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hms.model.Patient;

import com.hospital.hms.service.PatientService;
import com.hospital.hms.service.SecurityService;

import jakarta.validation.Valid;


@Controller
public class PatientController {

	@Autowired
	private PatientService patService;
	
	@Autowired
	private SecurityService secService;
		
	@GetMapping("/patients")
	public String listPatients(Model model) {
		System.out.println("Inside get patients");
		model.addAttribute("patients", patService.listPat());
		return "Patient/patients";
	}

	@GetMapping("/patient/new")
	public String showCreateForm(Model model) {
		System.out.println("Inside get patient new");
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "Patient/create_patient";
	}
	
	@PostMapping("/patient/new")
	public String savePat(@Valid Patient patient, BindingResult result) {
		System.out.println("Inside post patient new");
		boolean valid = patService.valid(patient,result);
		String res = "";
		if (valid) {
			res = "Patient/create_patient";
		}
		else {
			if(secService.getCurrentUserRole().equals("user")) {
				res = "redirect:/userpage";
			}
			else {
				res = "redirect:/patientmain";
			}
		}
		return res;
	}
	
	@GetMapping("/patient/{patientId}")
	public String showUpdateForm(@Valid @PathVariable("patientId") int id, Model model) {
		Patient patient = patService.getUsingId(id);
		model.addAttribute("patient", patient);
		return "Patient/update_patient";
	}

	@PostMapping("patients/update")
	public String updatePatient(@Valid Patient patients, BindingResult result) {
		System.out.println("Inside post patient update");
		boolean valid = patService.update(patients, result);
		String res = "";
		if (valid) {
			res = "Patient/create_patient";
		}
		else {
			if(secService.getCurrentUserRole().equals("user")) {
				res = "redirect:/userpage";
			}
			else {
				res = "redirect:/patientmain";
			}
		}
		return res;
	}
		


	@GetMapping("/patient/delete/{patientId}")
	public String deleteStudent(@Valid @PathVariable("patientId") int id) {
		System.out.println(id);
		patService.deletePatientInfo(id);
		return "redirect:/patients";
	}

}
