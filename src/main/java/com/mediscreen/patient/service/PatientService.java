package com.mediscreen.patient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.patientRepository;

@Service
public class PatientService {

	@Autowired
	private patientRepository patientRepository;
	
	public Optional<Patient> getPatient(final Integer id) {
		return patientRepository.findById(id);
	}
	
	public Iterable<Patient> getPatients() {
		return patientRepository.findAll();
	}
	
	public void deletePatient(final Integer id) {
		patientRepository.deleteById(id);
	}
	
	public Patient savePatient(Patient patient) {
		Patient savedPatient = patientRepository.save(patient);
		return savedPatient;
	}
	
}
