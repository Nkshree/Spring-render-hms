package com.hospital.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hms.model.Doctor;
import com.hospital.hms.service.DoctorService;

import jakarta.validation.Valid;

@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService docService;

	@PostMapping("/doctors")
	public String saveDoctor(@Valid Doctor doctor, BindingResult result) {
		boolean valid = docService.validAndSave(doctor,result);
		String res = "";
		if (valid) {
			res = "Doctor/create_doctor";
		}
		else {
			res = "redirect:/doctors";
		}
		return res;
	}

	
	@GetMapping("/doctors")
	public String listDoctors(Model model) {
	    model.addAttribute("doctors", docService.listDoc());
	    return "Doctor/doctors";
	}
	@GetMapping("/doctor/new")
	public String showCreateForm(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "Doctor/create_doctor";
	}

	@GetMapping("/doctor/{doctorId}")
	public String showUpdateForm(@PathVariable("doctorId") int id, Model model) {
		Doctor doctor = docService.getUsingId(id);
		model.addAttribute("doctor", doctor);
		return "Doctor/update_doctor";
	}
	@PostMapping("doctors/update")
	public String updateDoctor(@Valid Doctor doctor) {
		docService.update(doctor);
		return "redirect:/doctors";
	}
	
	@GetMapping("/doctor/delete/{doctorId}")
	public String deleteDoctor(@PathVariable("doctorId") int id) {
		docService.deleteDoctorInfo(id);
	    return "redirect:/doctors";
	}
	
}
