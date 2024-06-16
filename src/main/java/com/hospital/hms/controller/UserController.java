package com.hospital.hms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospital.hms.model.User;
import com.hospital.hms.service.UserService;

import jakarta.validation.Valid;


@Controller
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService usrService;
	
	@GetMapping("/signup")
    public String signupFrom(@Valid Model model) {
		System.out.println("Inside signup form");
		model.addAttribute("user", new User());
		return "Main/signUp";
    }
	

	@GetMapping("/reset")
	public String resetForm(@Valid Model model) {
	    System.out.println("inside reset form");
	    model.addAttribute("user", new User());
	    return "Main/reset";
	}

	@PostMapping("/reset")
	public String resetSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
	    System.out.println("inside post reset");
	    boolean success = usrService.resetPassword(user,bindingResult);
	    System.out.println(success);
	    String res = "";
	    if (success) {
	    	 redirectAttributes.addFlashAttribute("passwordResetSuccess", true);
	    	  res = "redirect:/login";
	    }
	    else {
	    	res = "Main/reset";
	    }
	    
	    return res;
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("inside new_login using spring security");
		return "Main/new_login";
	}
	
	@GetMapping("/userpage")
	public String userPage (Model model, Principal principal) {
		System.out.println("Inside user page");
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "Main/user";
	}
	
	@GetMapping("/adminpage")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "Main/main";
	}
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") User user) {
		System.out.println("Inside user register page");
		return "Main/signUp";
	}
	
	@PostMapping("/registration")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		boolean success = usrService.signup(user, bindingResult);
		String res = "";
		System.out.println(success);
		if(success) {
			redirectAttributes.addFlashAttribute("messageOnRegistration", true);
			res = "redirect:/login";
		}
		else {
			res = "Main/signUp";
		}
		return res;
	}
	@GetMapping("/errors")
	public String accessDenied() {
		return "Main/error";
	}
}
