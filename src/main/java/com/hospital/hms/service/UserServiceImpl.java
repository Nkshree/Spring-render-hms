package com.hospital.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.User;
import com.hospital.hms.repo.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean resetPassword(User user, BindingResult bindingResult) {
	    User existingUser = userRepo.findByUserName(user.getUserName());
	    if (existingUser != null) {
	    	if(user.getPassword().equals(user.getConfirmpassword()) && !(bindingResult.hasErrors())) {
	    		existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
		        existingUser.setConfirmpassword(passwordEncoder.encode(user.getConfirmpassword()));
		        userRepo.save(existingUser);
		        return true;
	    	}
	    	else {
	    		return false;
	    	}
	        
	    } else {
	        return false;
	    }
	}


	@Override
	public boolean login(User user) {
	    User existingUser = userRepo.findByUserName(user.getUserName());
	    if(user != null && user.getUserName().equals("admin@gmail.com")&& user.getPassword().equals("Admin@123")) {
	    	return true;
	    }
	    else if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public boolean signup(@Valid User user, BindingResult bindingResult) {
		if(user.getPassword().equals(user.getConfirmpassword())&& !(bindingResult.hasErrors())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setConfirmpassword(passwordEncoder.encode(user.getConfirmpassword()));
			userRepo.save(user);
			return true;
		}
		return false;	
	}
}
