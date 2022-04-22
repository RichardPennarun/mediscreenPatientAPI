package com.mediscreen.patient.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * Read - Get a Patient
	 * 
	 * @param id an int
	 * @return An optional Patient
	 */
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable("id") final Integer id) {
		Optional<Patient> patient = patientService.getPatient(id);
		if (patient.isPresent()) {
			return patient.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all patients
	 * 
	 * @return - An Iterable object of Patient full filled
	 */

	@GetMapping("/patients")
	public Iterable<Patient> getPatients() {
		return patientService.getPatients();
	}

	/**
	 * Create - Add a new Patient
	 * 
	 * @param patient An object patient
	 * @return The patient object saved
	 */
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	/**
	 * Delete - Delete a Patient
	 * 
	 * @param id an int
	 * @return void
	 */
	@DeleteMapping("/patient/{id}")
	public void deletePatient(@PathVariable("id") final Integer id) {
		patientService.deletePatient(id);
	}

	/**
	 * Update a Patient
	 * 
	 * @param id an int, patient An object patient
	 * @return The patient object updated
	 */
	@PutMapping("/patient/{id}")
	public Patient updatePatient(@PathVariable("id") final Integer id, @RequestBody Patient patient) {
		Optional<Patient> b = patientService.getPatient(id);
		if (b.isPresent()) {
			Patient currentPatient = b.get();

			String lastName = patient.getLastName();
			if (lastName != null) {
				currentPatient.setLastName(lastName);
			}
			String firstName = patient.getFirstName();
			if (firstName != null) {
				currentPatient.setFirstName(firstName);
			}
			String dob = patient.getDob();
			if (dob != null) {
				currentPatient.setDob(dob);
			}
			String sex = patient.getSex();
			if (sex != null) {
				currentPatient.setSex(sex);
			}
			String address = patient.getAddress();
			if (address != null) {
				currentPatient.setAddress(address);
			}
			String phone = patient.getPhone();
			if (phone != null) {
				currentPatient.setPhone(phone);
			}

			patientService.savePatient(currentPatient);
			return currentPatient;
		} else {
			return null;
		}
	}

}
