package com.hospital.hms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Doctor;
import com.hospital.hms.repo.DoctorRepo;

import jakarta.validation.Valid;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorRepo docRepo;
	@Override
	public void deleteDoctorInfo(int id) {
		
		Doctor doctor = docRepo.findById(id).orElseThrow();
		docRepo.delete(doctor);
		
	}

	@Override
	public List<Doctor> listDoc() {
		List<Doctor> doc = new ArrayList<>();
		doc.addAll(docRepo.findAll());
		return doc; 
	}

	@Override
	public Doctor getUsingId(int id) {
		return docRepo.findById(id).get();
	}

	@Override
	public void update(@Valid Doctor doctor) {
		docRepo.save(doctor);
	}

	@Override
	public boolean validAndSave(@Valid Doctor doctor, BindingResult result) {
		if (result.hasFieldErrors()) {
			return true;
		}
		else {
			docRepo.save(doctor);
			return false;
		}
	}

}
