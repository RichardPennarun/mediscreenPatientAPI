package com.mediscreen.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;

@SpringBootTest
public class mediscreenPatientServiceTest {
	
	@Autowired
	private PatientService patientService;

	@Test
	public void patientServiceTest() {
		Patient patientToSave = new Patient();
		patientToSave.setLastName("Pennarun");
		patientToSave.setFirstName("Adam");
		patientToSave.setDob("2014-12-24");
		patientToSave.setSex("M");
		patientToSave.setAddress("75020 Paris");
		patientToSave.setPhone("888-88-88");

		Patient createdPatient = patientService.savePatient(patientToSave);
		assertTrue(createdPatient == patientToSave);

		patientService.getPatients();
		
		patientService.getPatient(createdPatient.getId());
		
		patientService.deletePatient(createdPatient.getId());
		
	}
	

}
