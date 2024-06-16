package com.hospital.hms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Feedback {
	
	
	@Id
	@Column
	@NotBlank(message = "Name is required")
	private String name;

	
	@Column
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	
	@Column
	@NotBlank(message = "Feedback is required")
	private String feedback;

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", email=" + email + ", feedback=" + feedback + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
