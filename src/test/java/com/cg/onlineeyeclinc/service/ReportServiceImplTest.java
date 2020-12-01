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
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.ReportIdNotFoundException;

import junit.framework.TestCase;

class ReportServiceImplTest extends TestCase {
	ReportServiceImpl service;
	
	IPatientService patientService = new PatientServiceImpl();
	
	@BeforeEach
	protected void setUp() throws Exception {
		service = new ReportServiceImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testReportServiceImpl() {
		assertTrue(service instanceof ReportServiceImpl);
	}

	@Test
	public void testAddReport() {
		Report report = new Report( LocalDate.of(2010, 10, 11), "Blindness", "long", "short", "uyt");
		
		report = service.addReport(report);
		
		assertEquals(report.getDescriptionOfReport(),"Blindness");
	}

	@Test
	public void testUpdateReport() {
		Report rep = new Report( LocalDate.of(2012, 11, 02), "longsite", "bite", "notclear", "5");
		
		rep = service.addReport(rep);
		
		// rep.setVisualAcuityDistance("point");
		// rep=service.updateReport(rep);
		
	
		String descriptionOfReport="longsite";
		
		rep.setDescriptionOfReport(descriptionOfReport);
		
		rep=service.updateReport(rep);

		assertEquals(rep.getDescriptionOfReport(),"longsite");

	}

	@Test
	public void testRemoveReport() throws ReportIdNotFoundException {
		Report rep = new Report( LocalDate.of(2020, 10, 21), "notsite", "iop", "mnk", "5");

		rep = service.addReport(rep);
		rep = service.removeReport(rep.getReportId());

		assertNull(rep);
	}
@Test
	public void testViewReport() throws ReportIdNotFoundException, PatientIdNotFoundException {
		Report rep = new Report( LocalDate.of(2016, 12, 11), "sbi", "five", "large", "low");
		Patient patient = new Patient("Patient", 25, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		rep = service.addReport(rep);
		
		rep.setPatient(patient);
		patient.setReport(rep);
		patient = patientService.addPatient(patient);
		rep= service.viewReport(rep.getReportId(), rep.getPatient().getPatientId());
		assertEquals(rep.getDescriptionOfReport(),"sbi");
		
	}

	@Test
	public void testViewAllReport() {
		List<Report> reportList = service.viewAllReport(LocalDate.of(2018, 12, 11));
		assertNotNull(reportList);
	}

}
