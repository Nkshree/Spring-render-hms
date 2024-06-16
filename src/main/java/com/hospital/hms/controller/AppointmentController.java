package com.hospital.hms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hms.model.Appointment;
import com.hospital.hms.service.AppointmentService;

@Controller
//@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public String getAllAppointments(Model model) {
        model.addAttribute("appointment",appointmentService.getAllAppointments()); 
        return "Appointment/appointment";
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointmentById(id);
    }
    @GetMapping("/appointment/new")
    public String showAppointmentForm(Model model) {
    	System.out.println("Inside show appointment form");
        Appointment app = new Appointment();
        model.addAttribute("appointment",app);
        return "Appointment/create_appointment";
        		
    }

    @PostMapping("/appointments")
    public String createAppointment(Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return "redirect:/appointments";
    }
    @GetMapping("/appointment/update/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Appointment app = appointmentService.getAppointmentById(id);
		model.addAttribute("appointment", app);
		return "Appointment/update_appointment";
	}
    @PostMapping("/appointment/update")
    public String updateAppointment(Appointment app) {
        appointmentService.updateAppointment(app);
        return "redirect:/appointments";
    }

    @GetMapping("/appointment/delete/{id}")
    public String deleteAppointment(@PathVariable("id") int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
