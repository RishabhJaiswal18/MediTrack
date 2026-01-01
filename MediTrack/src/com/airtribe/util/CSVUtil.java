package com.airtribe.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.airtribe.entity.Patient;

public class CSVUtil {

	private CSVUtil() {

	}

	public static void writePatientsToCSV(String filePath, List<Patient> patients) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Patient p : patients) {
				writer.write(p.getId() + "," + p.getName() + "," + p.getAge() + "," + p.getPhoneNumber() + ","
						+ p.getMedicalHistory());
				writer.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error writing CSV", e);
		}
	}

	public static List<Patient> readPatientsFromCSV(String filePath) {
		List<Patient> patients = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				Patient patient = new Patient(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3],
						data[4]);
				patients.add(patient);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error reading CSV", e);
		}

		return patients;
	}
}
