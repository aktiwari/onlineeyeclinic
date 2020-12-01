package com.cg.onlineeyeclinc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.DoctorIdNotFoundException;
import com.cg.onlineeyeclinc.service.AppointmentServiceImpl;
import com.cg.onlineeyeclinc.service.IAppointmentService;
import com.cg.onlineeyeclinc.service.ITestService;
import com.cg.onlineeyeclinc.service.TestServiceImpl;

/**The DoctorRepositoryImpl class provides methods to persist the data or update or remove or view from database
 * 
 * @author Kondraju Praneeth
 *
 */

public class DoctorRepositoryImpl implements IDoctorRepository{
	
	private EntityManager entityManager;
	
	private IAppointmentService appService = new AppointmentServiceImpl();
	
	private ITestService  testService = new TestServiceImpl();
	
	/*
	 * Constructor to obtain the entity manager to perform CRUD operations and store in DB
	 */
	public DoctorRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	/**
	 * This method takes doctor object and store doctor details to DB
	 * @param doctor - doctor entity details 
	 */

	@Override
	public Doctor addDoctor(Doctor doctor) {
		entityManager.persist(doctor);
		return doctor;
	}
	
	/**
	 * This method takes doctor object and update doctor details in DB
	 * @param doctor - doctor entity details 
	 */

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		entityManager.merge(doctor);
		return doctor;
	}
	
	/**
	 * This method takes doctorId parameter and delete doctor details from DB
	 * @param doctor - doctorId - integer value to display
	 */

	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {
		Doctor doc = entityManager.find(Doctor.class, doctorId);
		if(doc == null) {
			throw new DoctorIdNotFoundException(doctorId);
		}
		entityManager.remove(doc);
		doc = null;
		return doc;
	}
	
	/**
	 * This method takes doctorId parameter and display doctor details from DB
	 * @param doctorId - integer value to display doctor based on doctorId
	 * @return Doctor Object
	 */

	@Override
	public Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		Doctor doc = entityManager.find(Doctor.class, doctorId);
		if(doc == null) {
			throw new DoctorIdNotFoundException(doctorId);
		}
		return doc;
	}
	
	/**
	 * This method is used to fetch all doctors details from DB
	 * @return list of doctors 
	 */

	@Override
	public List<Doctor> viewDoctorsList() {
		TypedQuery<Doctor> query= entityManager.createQuery("select d from Doctor d", Doctor.class);
		List<Doctor> allDoctors = query.getResultList();
		return allDoctors;
	}
	
	/**
	 * This method is used to commit transaction.
	 */

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}
	
	/**
	 * This method is used to begin the transaction.
	 */

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	/**
	 * This method returns All Appointments
	 */

	@Override
	public List<Appointment> viewAppointments() {
		List<Appointment> allAppointments = appService.viewAllAppointments();
		return allAppointments;
	}

	
	/**
	 * This method creates Test
	 */
	@Override
	public Tests createTest(Tests test) {
		test = testService.addTest(test);
		return test;
	}

}
