package com.hospital.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.hospital.hms.model.Doctor;

import jakarta.validation.Valid;
@Service
public interface DoctorService {


	void deleteDoctorInfo(int id);

	List<Doctor> listDoc();

	Doctor getUsingId(int id);

	void update(@Valid Doctor doctor);

	boolean validAndSave(@Valid Doctor doctor, BindingResult result);

}
