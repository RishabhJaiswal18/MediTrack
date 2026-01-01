package com.airtribe.meditrack;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.airtribe.entity.Appointment;
import com.airtribe.entity.Doctor;
import com.airtribe.entity.Patient;
import com.airtribe.enums.Specialization;
import com.airtribe.service.AppointmentService;
import com.airtribe.service.DoctorService;
import com.airtribe.service.PatientService;
import com.airtribe.util.CSVUtil;

public class MediTrack {

	private static final PatientService patientService = new PatientService();
	private static final DoctorService doctorService = new DoctorService();
	private static final AppointmentService appointmentService = new AppointmentService();
	private static final String PATIENT_CSV_FILE = "patients.csv";

	static {
		System.out.println("MediTrack Application Initializing...");
	}

	public static void main(String[] args) {

		if (args.length > 0 && "--loadData".equals(args[0])) {
			loadPatientsFromCSV();
		}

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== MediTrack Menu =====");
			System.out.println("1. Add Patient");
			System.out.println("2. Add Doctor");
			System.out.println("3. Book Appointment");
			System.out.println("4. Cancel Appointment");
			System.out.println("5. View All Appointments");
			System.out.println("6. Save Patients to CSV");
			System.out.println("7. Load Patients from CSV");
			System.out.println("8. Exit");

			System.out.print("Choose option: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> addPatient(sc);
			case 2 -> addDoctor(sc);
			case 3 -> bookAppointment(sc);
			case 4 -> cancelAppointment(sc);
			case 5 -> viewAppointments();
			case 6 -> savePatientsToCSV();
			case 7 -> loadPatientsFromCSV();
			case 8 -> {
				System.out.println("Exiting MediTrack...");
				return;
			}
			default -> System.out.println("Invalid option!");
			}
		}
	}

	private static void addPatient(Scanner sc) {
		System.out.print("ID: ");
		int id = sc.nextInt();
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Age: ");
		int age = sc.nextInt();
		System.out.print("Phone: ");
		String phone = sc.next();
		System.out.print("Medical History: ");
		String history = sc.next();

		patientService.addPatient(new Patient(id, name, age, phone, history));
		System.out.println("Patient added successfully");
	}

	private static void addDoctor(Scanner sc) {
		System.out.print("ID: ");
		int id = sc.nextInt();
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Age: ");
		int age = sc.nextInt();
		System.out.print("Specialization (CARDIOLOGIST etc): ");
		Specialization specialization = Specialization.valueOf(sc.next());
		System.out.print("Consultation Fee: ");
		double fee = sc.nextDouble();

		doctorService.addDoctor(new Doctor(id, name, age, specialization, fee));
		System.out.println("Doctor added successfully");
	}

	private static void bookAppointment(Scanner sc) {
		System.out.print("Appointment ID: ");
		int id = sc.nextInt();

		Doctor doctor = doctorService.getAllDoctors().get(0);
		Patient patient = patientService.getAllPatients().get(0);

		Appointment appointment = new Appointment(id, doctor, patient, LocalDateTime.now());

		appointmentService.bookAppointment(appointment);
		System.out.println("Appointment booked successfully");
	}

	private static void cancelAppointment(Scanner sc) {
		System.out.print("Appointment ID: ");
		int id = sc.nextInt();
		appointmentService.cancelAppointment(id);
		System.out.println("Appointment cancelled");
	}

	private static void viewAppointments() {
		appointmentService.getAllAppointments().forEach(a -> System.out.println(a.getAppointmentId() + " | "
				+ a.getDoctor().getName() + " | " + a.getPatient().getName() + " | " + a.getStatus()));
	}

	private static void savePatientsToCSV() {
		List<Patient> patients = patientService.getAllPatients();
		CSVUtil.writePatientsToCSV(PATIENT_CSV_FILE, patients);
		System.out.println("Patients saved to CSV successfully");
	}

	private static void loadPatientsFromCSV() {
		List<Patient> patients = CSVUtil.readPatientsFromCSV(PATIENT_CSV_FILE);
		patients.forEach(patientService::addPatient);
		System.out.println("Patients loaded from CSV successfully");
	}

}
