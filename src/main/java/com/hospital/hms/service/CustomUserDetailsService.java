package com.hospital.hms.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.hms.model.User;
import com.hospital.hms.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUserName(username);
		
		if(Objects.isNull(user)) {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		return new CustomUserDetail(user);
	}

}
