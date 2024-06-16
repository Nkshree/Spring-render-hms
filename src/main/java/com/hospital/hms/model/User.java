package com.hospital.hms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


	@Entity
	@Table(name = "\"user\"")
	public class User {
	    @Id
	    @Column
	    @NotBlank(message = "Username cannot be blank")
	    private String userName;

	    @Column
	    @NotBlank(message = "Password cannot be blank")
	    @Size(min = 8, message = "Password should have at least 8 characters")
	    private String password;

	    @Column
	    @Size(min = 8, message = "Confirm Password should match the password")
	    private String confirmpassword;
	    
	    @Column
	    private String role = "user";

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		
	    
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
