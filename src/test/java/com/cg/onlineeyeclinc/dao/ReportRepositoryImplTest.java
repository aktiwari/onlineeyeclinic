package com.cg.onlineeyeclinc.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.ReportIdNotFoundException;
import com.cg.onlineeyeclinc.service.IPatientService;
import com.cg.onlineeyeclinc.service.PatientServiceImpl;

import junit.framework.TestCase;

public class ReportRepositoryImplTest extends TestCase {
	ReportRepositoryImpl reportrepos;
	IPatientService patientService = new PatientServiceImpl();

	@BeforeEach
	protected void setUp() throws Exception {
		reportrepos = new ReportRepositoryImpl();
		

	}

	@AfterEach
	protected void tearDown() throws Exception {
		reportrepos = null;

	}

	@Test
	public void testReportrepositoryImpl() {

		assertTrue(reportrepos instanceof ReportRepositoryImpl);

	}

	@Test
	public void testAddReport() {
		Report rep = new Report(LocalDate.of(2020, 10, 11), "nv", "bjb", "bh", "oip");

	reportrepos.beginTransaction();
		Report re = reportrepos.addReport(rep);
		reportrepos.commitTransaction();

		assertEquals(re.getDescriptionOfReport(), "nv");
	}

	@Test
	public void testViewReport()
			throws ReportIdNotFoundException, PatientIdNotFoundException {
		Report rep = new Report( LocalDate.of(2016, 12, 11), "sbi", "five", "large", "low");
		Patient patient = new Patient("Patient", 25, 874152963, "p@gmail.co", LocalDate.of(1990, 10, 1), "Patient", "Patient", "Nellore");
		Appointment appointment = new Appointment(LocalDate.of(2022, 5, 10), LocalTime.of(5, 10, 30) , 15000.00);
		patient.setAppointment(appointment);
		
		reportrepos.beginTransaction();
		rep = reportrepos.addReport(rep);
		reportrepos.commitTransaction();
		
		rep.setPatient(patient);
		patient.setReport(rep);
		patient = patientService.addPatient(patient);
		rep= reportrepos.viewReport(rep.getReportId(), patient.getPatientId());
		assertNotNull(rep);
	}

	@Test
	public void testViewAllReport() {
		
		List<Report> repList = reportrepos.viewAllReport( LocalDate.of(2002, 11, 10));

		assertNotNull(repList);
	}

	@Test
	public void testUpdateReport() throws ReportIdNotFoundException {

		Report rp = new Report(LocalDate.of(1999, 11, 10), "nb", "dcz", "poid", "mnv");

		reportrepos.beginTransaction();
		rp = reportrepos.addReport(rp);
		reportrepos.commitTransaction();
		LocalDate.of(2015, 12, 10);
		String descriptionOfReport = "helo";
		rp.setDescriptionOfReport(descriptionOfReport);;
		rp.setDateOfReport(LocalDate.of(2015, 12, 10));

		reportrepos.beginTransaction();
		reportrepos.updateReport(rp);
		reportrepos.commitTransaction();

		assertEquals(rp.getDescriptionOfReport(), "helo");
	}

	@Test
	public void testRemoveReport() throws ReportIdNotFoundException {
		Report rep = new Report(LocalDate.of(2020, 11, 10), "pra", "dep", "cxs", "kjh");

		reportrepos.beginTransaction();
		rep = reportrepos.addReport(rep);
		rep=reportrepos.removeReport(rep.getReportId());
		reportrepos.commitTransaction();
		
		assertNull(rep);
	}

}
