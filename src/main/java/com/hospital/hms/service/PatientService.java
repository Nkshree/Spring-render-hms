package com.hospital.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Patient;

import jakarta.validation.Valid;

@Service
public interface PatientService {
	
	//void savePatient(@Valid Patient patient);

	void deletePatientInfo(int id);

	List<Patient> listPat();

	Patient getUsingId(int id);

	boolean update(@Valid Patient patients, BindingResult result);

	boolean valid(@Valid Patient patient, BindingResult result);
	
}
