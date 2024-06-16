package com.hospital.hms.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		var authourities = authentication.getAuthorities();
		var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();
		System.out.println(roles);
		
		if (roles.orElse("").equalsIgnoreCase("ADMIN")) {
			System.out.println("admin");
			response.sendRedirect("/adminpage");
		} else if (roles.orElse("").equalsIgnoreCase("USER")) {
			System.out.println("user");
			response.sendRedirect("/userpage");
		} else {
			System.out.println("inside error");
			response.sendRedirect("/error");
		}
		
	}

}
