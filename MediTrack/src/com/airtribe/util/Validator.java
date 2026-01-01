package com.airtribe.util;

import com.airtribe.exception.InvalidDataException;

public final class Validator {

	private Validator() {

	}

	public static void validateName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidDataException("Name cannot be empty");
		}
	}

	public static void validateAge(int age) {
		if (age <= 0 || age > 120) {
			throw new InvalidDataException("Invalid age");
		}
	}

	public static void validatePhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new InvalidDataException("Invalid phone number");
		}
	}

	public static void validateFee(double fee) {
		if (fee <= 0) {
			throw new InvalidDataException("Consultation fee must be positive");
		}
	}
}
