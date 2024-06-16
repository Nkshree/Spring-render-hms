package com.hospital.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hms.model.Feedback;
import com.hospital.hms.service.FeedbackService;

import jakarta.validation.Valid;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedService;
	@PostMapping("/feedbacks")
	public String saveFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {
		boolean valid = feedService.valid(feedback,result);
		String res = "";
		if (valid) {
			res = "Feedback/create_feedback";
		}
		else {
			res = "redirect:/feedbacks";
		}
		return res;
	}

	@GetMapping("/feedbacks")
	public String listFeedbacks(Model model) {
		model.addAttribute("feedbacks", feedService.listAll());
		return "Feedback/feedback";
	}

	@GetMapping("/feedback/new")
	public String showCreateForm(Model model) {
		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "Feedback/create_feedback";
	}
}
