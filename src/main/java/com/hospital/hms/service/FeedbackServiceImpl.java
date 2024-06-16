package com.hospital.hms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Feedback;
import com.hospital.hms.repo.FeedbackRepo;

import jakarta.validation.Valid;


@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepo feedRepo;
//	@Override
//	public void saveFb(@Valid Feedback feedback) {
//		feedRepo.save(feedback);
//	}

	@Override
	public List<Feedback> listAll() {
		List<Feedback> feed = new ArrayList<>();
		feed.addAll(feedRepo.findAll());
		return feed;
	}

	@Override
	public boolean valid(@Valid Feedback feedback, BindingResult result) {
		if (result.hasFieldErrors()) {
			return true;
		}
		else {
			feedRepo.save(feedback);
			return false;
		}
	}

}
