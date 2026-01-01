package com.airtribe.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.airtribe.entity.Appointment;
import com.airtribe.exception.AppointmentNotFoundException;
import com.airtribe.util.DataStore;

public class AppointmentService {

	private final DataStore<Appointment> appointmentStore = new DataStore<>();

	public void bookAppointment(Appointment appointment) {
		appointment.confirm();
		appointmentStore.add(appointment);
	}

	public Appointment getAppointmentById(int id) {
		return appointmentStore.find(a -> a.getAppointmentId() == id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found: " + id));
	}

	public void cancelAppointment(int id) {
		Appointment appointment = getAppointmentById(id);
		appointment.cancel();
	}

	public List<Appointment> getAllAppointments() {
		return appointmentStore.getAll();
	}

	public Map<Integer, Long> appointmentsPerDoctor() {
		return appointmentStore.getAll().stream()
				.collect(Collectors.groupingBy(a -> a.getDoctor().getId(), Collectors.counting()));
	}
}
