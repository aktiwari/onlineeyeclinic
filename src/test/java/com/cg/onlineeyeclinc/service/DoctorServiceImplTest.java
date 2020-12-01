package com.cg.onlineeyeclinc.service;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;

import junit.framework.TestCase;

public class DoctorServiceImplTest extends TestCase {
	
	DoctorServiceImpl service;

	@BeforeEach
	protected void setUp() throws Exception {
		service = new DoctorServiceImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testDoctorServiceImpl() {
		assertTrue(service instanceof DoctorServiceImpl);
	}

	@Test
	public void testAddDoctor() {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		doc = service.addDoctor(doc);
		assertEquals(doc.getDoctorName(), "sai");
	}

	@Test
	public void testUpdateDoctor() {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		service.addDoctor(doc);
		doc.setAddress("Hyderabad");
		doc = service.updateDoctor(doc);
		assertEquals(doc.getAddress(), "Hyderabad");
	}

	@Test
	public void testDeleteDoctor() {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		doc =service.deleteDoctor(doc.getDoctorId());
		assertNull(doc);
	}

	@Test
	public void testViewDoctor() {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		doc = service.addDoctor(doc);
		Doctor docs = service.viewDoctor(doc.getDoctorId());
		assertEquals(docs.getDoctorName(), "sai");
		
	}

	@Test
	public void testViewDoctorsList() {
		List<Doctor> docs = service.viewDoctorsList();
		assertNotNull(docs);
	}
	
	@Test
	public void testViewAppointments() {
		List<Appointment> allAppointments = service.viewAppointments();
		assertNotNull(allAppointments);
	}
	
	@Test
	public void testCreateTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 15000.00);
		test = service.createTest(test);
		assertEquals(test.getTestCost(), 15000.00);
	}

}
