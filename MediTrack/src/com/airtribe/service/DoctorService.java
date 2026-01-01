package com.airtribe.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.airtribe.entity.Doctor;
import com.airtribe.util.DataStore;
import com.airtribe.util.Validator;

public class DoctorService {

	private final DataStore<Doctor> doctorStore = new DataStore<>();

	public void addDoctor(Doctor doctor) {
		Validator.validateName(doctor.getName());
		Validator.validateAge(doctor.getAge());
		Validator.validateFee(doctor.getConsultationFee());

		doctorStore.add(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorStore.getAll();
	}

	public Map<String, Long> countDoctorsBySpecialization() {
		return doctorStore.getAll().stream()
				.collect(Collectors.groupingBy(d -> d.getSpecialization().name(), Collectors.counting()));
	}

	public double averageConsultationFee() {
		return doctorStore.getAll().stream().mapToDouble(Doctor::getConsultationFee).average().orElse(0.0);
	}
}
