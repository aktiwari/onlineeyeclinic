package com.cg.onlineeyeclinc.dao;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.DoctorIdNotFoundException;

import junit.framework.TestCase;

public class DoctorRepositoryImplTest extends TestCase {
	
	DoctorRepositoryImpl  docRepo;
	
	@BeforeEach
	protected void setUp() throws Exception {
		docRepo = new DoctorRepositoryImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		docRepo = null;
	}
	
	@Test
	public void testDoctorRepositoryImpl() {
		assertTrue(docRepo instanceof DoctorRepositoryImpl);
	}

	@Test
	public void testAddDoctor() {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		docRepo.beginTransaction();
		Doctor d = docRepo.addDoctor(doc);
		docRepo.commitTransaction();
		assertEquals(d.getDoctorName(),"sai");
	}

	@Test
	public void testUpdateDoctor() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		docRepo.beginTransaction();
		doc = docRepo.addDoctor(doc);
		docRepo.commitTransaction();
		
		doc.setAddress("Hyderabad");
		
		docRepo.beginTransaction();
		docRepo.updateDoctor(doc);
		docRepo.commitTransaction();
		
		assertEquals(doc.getAddress(), "Hyderabad");
	}
	
	@Test
	public void testDeleteDoctor() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		docRepo.beginTransaction();
		doc = docRepo.addDoctor(doc);
		doc = docRepo.deleteDoctor(doc.getDoctorId());
		docRepo.commitTransaction();
		assertNull(doc);
	}

	@Test
	public void testViewDoctor() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30 AM", 987643210, "sai@gmail.com", "sai", "sai@#123", "Chennai");
		docRepo.beginTransaction();
		doc = docRepo.addDoctor(doc);
		docRepo.commitTransaction();
		doc = docRepo.viewDoctor(doc.getDoctorId());
		assertEquals(doc.getDoctorName(), "sai");
	}

	@Test
	public void testViewDoctorsList() {
		List<Doctor> docList = docRepo.viewDoctorsList();
		assertNotNull(docList);
	}
	
	@Test
	public void testViewAppointments() {
		List<Appointment> allAppointments = docRepo.viewAppointments();
		assertNotNull(allAppointments);
	}
	
	@Test
	public void testCreateTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 15000.00);
		test = docRepo.createTest(test);
		assertEquals(test.getTestCost(), 15000.00);
	}

}
