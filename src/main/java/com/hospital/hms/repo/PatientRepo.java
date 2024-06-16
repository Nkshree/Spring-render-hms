package com.hospital.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hms.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
