package com.mediscreen.patient;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mediscreen.patient.controller.PatientController;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;

@WebMvcTest(controllers = PatientController.class)
public class mediscreenPatientControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientService patientService;
	
	@Test
	public void testGetPatients() throws Exception {
		mockMvc.perform(get("/patients")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetPatient() throws Exception {
		mockMvc.perform(get("/patient/{id}", 2)).andExpect(status().isOk());
	}
	
	@Test
	public void testDeletePatient() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/patient/{id}", 2))
		.andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		  mockMvc.perform(post("/patient")
			      .content(asJsonString(new Patient()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	

	@Test
	public void testUpdatePatient() throws Exception {
		Optional<Patient> patient = Optional.of(new Patient());
		Patient patientToSave = new Patient();
		patientToSave.setLastName("Pennarun");
		patientToSave.setFirstName("Adam");
		patientToSave.setDob("2014-12-24");
		patientToSave.setSex("M");
		patientToSave.setAddress("75020 Paris");
		patientToSave.setPhone("888-88-88");
		
		when(patientService.getPatient(2)).thenReturn(patient);
		when(patientService.savePatient(patientToSave)).thenReturn(patientToSave);
		
		mockMvc.perform(put("/patient/{id}", 2)
				.content(asJsonString(patientToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.lastName", is("Pennarun")))
				.andExpect(jsonPath("$.firstName", is("Adam")))
				.andExpect(jsonPath("$.dob", is("2014-12-24")))
				.andExpect(jsonPath("$.sex", is("M")))
				.andExpect(jsonPath("$.address", is("75020 Paris")))
				.andExpect(jsonPath("$.phone", is("888-88-88")));
	}

}
