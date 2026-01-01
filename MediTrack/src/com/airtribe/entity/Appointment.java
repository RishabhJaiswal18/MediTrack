package com.airtribe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.airtribe.enums.AppointmentStatus;

public class Appointment implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	private int appointmentId;
	private Doctor doctor;
	private Patient patient;
	private LocalDateTime appointmentTime;
	private AppointmentStatus status;

	public Appointment(int appointmentId, Doctor doctor, Patient patient, LocalDateTime appointmentTime) {
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
		this.status = AppointmentStatus.PENDING;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void confirm() {
		this.status = AppointmentStatus.CONFIRMED;
	}

	public void cancel() {
		this.status = AppointmentStatus.CANCELLED;
	}

	/**
	 * Deep Copy implementation
	 */
	@Override
	public Appointment clone() {
		try {
			Appointment cloned = (Appointment) super.clone();

			// Deep copy patient & doctor
			cloned.patient = this.patient.clone();
			cloned.doctor = this.doctor; // Doctor is immutable enough here

			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Clone failed", e);
		}
	}
}
