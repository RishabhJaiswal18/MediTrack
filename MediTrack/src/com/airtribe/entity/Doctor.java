package com.airtribe.entity;

import com.airtribe.enums.Specialization;

public class Doctor extends Person {

	private Specialization specialization;
	private double consultationFee;

	public Doctor(int id, String name, int age, Specialization specialization, double consultationFee) {
		super(id, name, age);
		this.specialization = specialization;
		this.consultationFee = consultationFee;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public double getConsultationFee() {
		return consultationFee;
	}
}
