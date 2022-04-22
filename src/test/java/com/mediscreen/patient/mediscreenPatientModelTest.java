package com.mediscreen.patient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.patient.model.Patient;

@SpringBootTest
public class mediscreenPatientModelTest {

	@Test
	public void getPatientTest() {

		Patient p = new Patient();
		p.setLastName("Pennarun");
		p.setFirstName("Adam");
		p.setDob("2014-12-24");
		p.setSex("M");
		p.setAddress("75020 Paris");
		p.setPhone("888-88-88");

		assertThat(p.getLastName()).isEqualTo("Pennarun");
		assertThat(p.getFirstName()).isEqualTo("Adam");
		assertThat(p.getDob()).isEqualTo("2014-12-24");
		assertThat(p.getSex()).isEqualTo("M");
		assertThat(p.getAddress()).isEqualTo("75020 Paris");
		assertThat(p.getPhone()).isEqualTo("888-88-88");
	}

	@Test
	public void setPatientTest() {

		Patient patient = new Patient(52, "Pennarun", "Adam", "2014-12-24", "M", "75020 Paris", "888-88-88");

		assertThat(patient.getId()).isEqualTo(52);
		assertThat(patient.getLastName()).isEqualTo("Pennarun");
		assertThat(patient.getFirstName()).isEqualTo("Adam");
		assertThat(patient.getDob()).isEqualTo("2014-12-24");
		assertThat(patient.getSex()).isEqualTo("M");
		assertThat(patient.getAddress()).isEqualTo("75020 Paris");
		assertThat(patient.getPhone()).isEqualTo("888-88-88");
	}

}
