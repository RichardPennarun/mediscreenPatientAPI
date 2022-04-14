package com.mediscreen.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediscreen.patient.model.Patient;

@Repository
public interface patientRepository extends JpaRepository<Patient, Integer> {

}
