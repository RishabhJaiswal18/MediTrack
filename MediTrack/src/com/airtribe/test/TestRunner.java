package com.airtribe.test;

import com.airtribe.entity.Patient;

public class TestRunner {

	public static void main(String[] args) {

		Patient p1 = new Patient(1, "Amit", 30, "9999999999", "Diabetes");
		Patient p2 = p1.clone();

		System.out.println("Original Patient: " + p1.getName());
		System.out.println("Cloned Patient: " + p2.getName());

		System.out.println("Deep copy successful: " + (p1 != p2));
	}
}
