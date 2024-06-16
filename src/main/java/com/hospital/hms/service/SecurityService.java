package com.hospital.hms.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	 String getCurrentUserRole();
}
