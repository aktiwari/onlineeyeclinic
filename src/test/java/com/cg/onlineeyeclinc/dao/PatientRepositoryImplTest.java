package com.cg.onlineeyeclinc.dao;

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
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.service.IReportService;
import com.cg.onlineeyeclinc.service.ITestService;
import com.cg.onlineeyeclinc.service.ReportServiceImpl;
import com.cg.onlineeyeclinc.service.TestServiceImpl;

import junit.framework.TestCase;

public class PatientRepositoryImplTest extends TestCase {
	IPatientRepository repository;

	@BeforeEach
	protected void setUp() throws Exception {
		repository = new PatientRepositoryImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		repository = null;
	}

	@Test
	public void testPatientRepositoryImpl() {
		
		assertTrue(repository instanceof PatientRepositoryImpl);
	}

	@Test
	public void testAddPatient() {
		
		Patient patient = new Patient("Patient", 25, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
	    patient = repository.addPatient(patient);
	    repository.commitTransaction();
	    
	    assertEquals(patient.getPatientAge(), 25);
	}

	@Test
	public void testUpdatePatient() throws PatientIdNotFoundException {
		
		Patient patient = new Patient("Patient", 28, 873952963, "p@gmail.co", LocalDate.of(1991, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
		repository.commitTransaction();
		
	    int patientAge = 30;
		String patientAddress = "Hyderabad";
	    patient.setPatientAge(patientAge);
	    patient.setPatientAddress(patientAddress);
	    
	    repository.beginTransaction();
		patient = repository.updatePatient(patient);
		repository.commitTransaction();
	    
	    assertEquals(patient.getPatientAge(),30);
	}

	@Test
	public void testDeletePatient() throws PatientIdNotFoundException {
		
		Patient patient = new Patient("Patient1", 30, 843652963, "p@gmail.co", LocalDate.of(1990, 1, 1), "Patient1", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
	    patient = repository.deletePatient(patient.getPatientId());
	    repository.commitTransaction();
	    
	    assertNull(patient);
	}

	@Test
	public void testViewPatientList() {
		
	    List<Patient> patientList = repository.viewPatientList();
	    
	    assertNotNull(patientList);
	}

	@Test
	public void testViewPatient() throws PatientIdNotFoundException {
		
		Patient patient = new Patient("Patient4", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
		repository.commitTransaction();
		
	    patient = repository.viewPatient(patient.getPatientId());
	    
	    
	    assertEquals(patient.getPatientAge(),18);
	}
	
	@Test
	public void testBookAppointment() {
		
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
		repository.commitTransaction();
		
		assertEquals(patient.getAppointment().getAppointmentId(),appointment.getAppointmentId());
	}
	
	@Test
	public void testViewAppointmentDetails() throws AppointmentIdNotFoundException {
		
		Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
		repository.commitTransaction();
		
	    appointment = repository.viewAppointmentDetails(appointment.getAppointmentId());
	    
	    assertNotNull(appointment);
	}
	
	
	@Test
	public void testViewReport() throws PatientIdNotFoundException {
		
		IReportService reportService = new ReportServiceImpl();
		Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
		Patient patient = new Patient("Patient10", 18, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		patient.setAppointment(appointment);
		Report report = new Report( LocalDate.of(2012, 11, 02), "longsite", "bite", "notclear", "5");
		
		report = reportService.addReport(report);
		
		report.setPatient(patient);
		patient.setReport(report);
		
		repository.beginTransaction();
		patient = repository.addPatient(patient);
		repository.commitTransaction();
		
		report = repository.viewReport(patient.getPatientId());
		
		assertEquals(report.getVisualAcuityDistance(), "5");
	}
	
	@Test
	public void testViewAllTests() {
		ITestService testService = new TestServiceImpl();
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		
		test = testService.addTest(test);
		
		List<Tests> allTest = repository.viewAllTests();
		
		assertNotNull(allTest);
	}

}
