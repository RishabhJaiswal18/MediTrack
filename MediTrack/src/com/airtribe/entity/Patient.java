package com.airtribe.entity;

public class Patient extends Person implements Cloneable {

	private String phoneNumber;
	private String medicalHistory;

	public Patient(int id, String name, int age, String phoneNumber, String medicalHistory) {
		super(id, name, age);
		this.phoneNumber = phoneNumber;
		this.medicalHistory = medicalHistory;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	@Override
	public Patient clone() {
		try {
			return (Patient) super.clone(); // Strings are immutable → safe
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Patient clone failed", e);
		}
	}
}
