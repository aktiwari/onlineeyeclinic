package com.cg.onlineeyeclinc.service;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Tests;

import junit.framework.TestCase;

public class PatientServiceImplTest extends TestCase{
	
	IPatientService service;

	@BeforeEach
	protected void setUp() throws Exception {
		service = new PatientServiceImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testPatientServiceImpl() {
		
		assertTrue(service instanceof PatientServiceImpl);
	}

	@Test
	public void testAddPatient() {
		
		Patient patient = new Patient("Patient", 25, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
	    patient = service.addPatient(patient);
	    
	    assertEquals(patient.getPatientAge(), 25);
	}

	@Test
	public void testUpdatePatient() {
		
		Patient patient = new Patient("Patient", 28, 873952963, "p@gmail.co", LocalDate.of(1991, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		patient = service.addPatient(patient);
		
	    int patientAge = 30;
		String patientAddress = "Hyderabad";
	    patient.setPatientAge(patientAge);
	    patient.setPatientAddress(patientAddress);
	    
		patient = service.updatePatient(patient);
	    
	    assertEquals(patient.getPatientAge(),30);
	    
	}

	@Test
	public void testDeletePatient() {
		
		Patient patient = new Patient("Patient1", 30, 843652963, "p@gmail.co", LocalDate.of(1990, 1, 1), "Patient1", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		patient = service.addPatient(patient);
		
	    patient = service.deletePatient(patient.getPatientId());
	    
	    assertNull(patient);
	}

	@Test
	public void testViewPatient() {
		
		Patient patient = new Patient("Patient4", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		patient = service.addPatient(patient);
		
	    patient = service.viewPatient(patient.getPatientId());
	    
	    assertEquals(patient.getPatientAge(),18);
	}

	@Test
	public void testViewPatientList() {
		
	    List<Patient> patientList = service.viewPatientList();
	    
	    assertNotNull(patientList);
	}
	
	@Test
	public void testBookAppointment() {
		
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		
		patient = service.addPatient(patient);
		
		assertEquals(patient.getAppointment().getAppointmentId(),appointment.getAppointmentId());
	}
	
	@Test
	public void testViewAppointmentDetails() {
		
		Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		
		patient = service.addPatient(patient);
		
	    appointment =service.viewAppointmentDetails(appointment.getAppointmentId());
	    
	    assertNotNull(appointment);
	}
	
	@Test
	public void testViewReport() {
		
		IReportService repService = new ReportServiceImpl();
		Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		Report report = new Report( LocalDate.of(2012, 11, 02), "longsite", "bite", "notclear", "5");
		
		report = repService.addReport(report);
		
		report.setPatient(patient);
		patient.setReport(report);
		
		patient = service.addPatient(patient);
		
		report = service.viewReport(patient.getPatientId());
		
		assertEquals(report.getVisualAcuityDistance(), "5");
	}
	
	@Test
	public void testViewAllTests() {
		ITestService testService = new TestServiceImpl();
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		
		test = testService.addTest(test);
		
		List<Tests> allTest = service.viewAllTests();
		
		assertNotNull(allTest);
	}
}
