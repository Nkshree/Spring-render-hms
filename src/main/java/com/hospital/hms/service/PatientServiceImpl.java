package com.hospital.hms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Patient;

import com.hospital.hms.repo.PatientRepo;


import jakarta.validation.Valid;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepo patRepo;
	
	
	@Override
	public void deletePatientInfo(int id) {
		System.out.println(patRepo.findById(id).toString());
		Patient patient = patRepo.findById(id).orElseThrow();
		patRepo.delete(patient);
	}

	@Override
	public List<Patient> listPat() {
		List<Patient> list = new ArrayList<>();
		list.addAll(patRepo.findAll());
		return list;
	}

	@Override
	public Patient getUsingId(int id) {
		return patRepo.findById(id).get();
	}

	@Override
	public boolean update(@Valid Patient patients, BindingResult result) {
		if (result.hasFieldErrors()) {
			return true;
		}
		else {
			patRepo.save(patients);
			return false;
		}
		
	}

	@Override
	public boolean valid(@Valid Patient patient, BindingResult result) {
		if (result.hasFieldErrors()) {
			return true;
		}
		else {
			patRepo.save(patient);
			return false;
		}
	}
}
	
	

 
