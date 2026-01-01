package com.airtribe.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.airtribe.entity.Appointment;

public class AppointmentPersistenceUtil {

	private AppointmentPersistenceUtil() {
	}

	public static void saveAppointments(String filePath, List<Appointment> appointments) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(appointments);
		} catch (IOException e) {
			throw new RuntimeException("Serialization failed", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Appointment> loadAppointments(String filePath) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			return (List<Appointment>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("Deserialization failed", e);
		}
	}
}
