package com.hospital.hms.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.User;

import jakarta.validation.Valid;

@Service
public interface UserService {

	boolean resetPassword(@Valid User user, BindingResult bindingResult);

	boolean login(@Valid User user);

	boolean signup(@Valid User user, BindingResult bindingResult);

}
