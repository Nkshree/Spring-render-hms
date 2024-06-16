package com.hospital.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Feedback;

import jakarta.validation.Valid;


@Service
public interface FeedbackService {

	//void saveFb(Feedback feedback);

	List<Feedback> listAll();

	boolean valid(@Valid Feedback feedback, BindingResult result);

}
