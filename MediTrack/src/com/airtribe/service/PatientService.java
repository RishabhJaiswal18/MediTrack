package com.airtribe.service;

import java.util.List;

import com.airtribe.entity.Patient;
import com.airtribe.util.DataStore;
import com.airtribe.util.Validator;

public class PatientService {

	private final DataStore<Patient> patientStore = new DataStore<>();

	public void addPatient(Patient patient) {
		Validator.validateName(patient.getName());
		Validator.validateAge(patient.getAge());
		Validator.validatePhone(patient.getPhoneNumber());

		patientStore.add(patient);
	}

	public List<Patient> getAllPatients() {
		return patientStore.getAll();
	}
}
