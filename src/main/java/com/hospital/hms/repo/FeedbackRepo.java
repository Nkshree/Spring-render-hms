package com.hospital.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hms.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, String>  {

}
