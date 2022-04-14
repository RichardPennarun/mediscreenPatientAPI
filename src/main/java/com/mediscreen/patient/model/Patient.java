package com.mediscreen.patient.model;

import javax.persistence.*;

@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="date_of_birth")
	private String dob;
	
	private String sex;
	
	private String address;
	
	private String phone;

	public Patient() {
		
	}
	
	public Patient(int id, String lastName, String firstName, String dob, String sex, String address, String phone) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dob = dob;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
	
	

}
