package com.hospital.hms.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {
    @Id
    @Column
    @NotNull(message = "Patient ID is required")
    private int patientId;

    @Column
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;

    @Column
    @NotNull(message = "Age is required")
    private int age;

    @Column
    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;

    @Column
    @NotNull(message = "Date of birth is required")
    private Date dob;

    @Column
    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address should not exceed 200 characters")
    private String address;

    @Column
    @NotNull(message = "Mobile number is required")
    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    private String mobile;

    @Column(unique=true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column
    @NotBlank(message = "Guardian name is required")
    @Size(max = 100, message = "Guardian name should not exceed 100 characters")
    private String gname;

    @Column
    @NotNull(message = "Guardian's Mobile number is required")
    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    private String gmobile;

    public Patient() {
        // Default constructor
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", gname=" + gname
				+ ", gmobile=" + gmobile + "]";
	}


	public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGmobile() {
        return gmobile;
    }

    public void setGmobile(String gmobile) {
        this.gmobile = gmobile;
    }


}

