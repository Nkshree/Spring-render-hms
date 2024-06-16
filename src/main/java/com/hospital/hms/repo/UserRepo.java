package com.hospital.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hms.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	 User findByUserName(String userName);
	
}
