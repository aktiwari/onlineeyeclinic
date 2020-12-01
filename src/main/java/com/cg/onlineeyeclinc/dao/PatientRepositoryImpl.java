package com.cg.onlineeyeclinc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.service.AppointmentServiceImpl;
import com.cg.onlineeyeclinc.service.ReportServiceImpl;
import com.cg.onlineeyeclinc.service.TestServiceImpl;

/**
 * PatientRepositoryImpl class provides methods to Add Patient, remove Patient,
 * view Patient, view all Patient, update Patient, book appointment, view
 * Appointment and view report
 * 
 * @author Prudhvi Mypati
 * 
 */

public class PatientRepositoryImpl implements IPatientRepository {

	private EntityManager entityManager;

	AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();
	ReportServiceImpl reportService = new ReportServiceImpl();
	TestServiceImpl testService = new TestServiceImpl();

	/** Constructor to get the entity manager */
	public PatientRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	/**
	 * This method Add Patient object in to Patient table and returns the added Patient object
	 * 
	 * @param patient - patient entity details
	 */
	@Override
	public Patient addPatient(Patient patient) {
		bookAppointment(patient.getAppointment());
		entityManager.persist(patient);
		System.out.println("Patient details Added Successfully");
		return patient;
	}

	/**
	 * This method updates the booking details by searching with id and returns the updated Patient object
	 * 
	 * Updates the Patient object if the Patient id is present in the Database and returns the updated Patient object
	 * 
	 * If the Patient Id is not found then it throw PatientIdNotFound Exception
	 * 
	 * @param patient - patient entity details
	 * 
	 */
	@Override
	public Patient updatePatient(Patient patient) throws PatientIdNotFoundException {
		int id = patient.getPatientId();
		patient = entityManager.find(Patient.class, id);
		if (patient == null) {
			throw new PatientIdNotFoundException(id);
		}
		entityManager.merge(patient);
		System.out.println("Patient details updated Successfully");
		return patient;
	}

	/**
	 * This method takes Patient Id and deletes the Patient based on Id and returns null
	 * 
	 * If the Patient Id is not found then it throw PatientIdNotFound Exception
	 * 
	 * @param patient - patientId - integer value to delete
	 * 
	 */
	@Override
	public Patient deletePatient(int patientId) throws PatientIdNotFoundException {
		Patient patient = entityManager.find(Patient.class, patientId);
		if (patient == null) {
			throw new PatientIdNotFoundException(patientId);
		}
		entityManager.remove(patient);
		System.out.println("Patient Deleted Successfully");
		patient = null;
		return patient;
	}

	/**
	 * This method returns the Patient List present in the Patient Table
	 * 
	 * If patient list is null, returns null
	 * 
	 * @return list of patients
	 * 
	 */
	@Override
	public List<Patient> viewPatientList() {
		TypedQuery<Patient> query = entityManager.createQuery("SELECT patient FROM Patient patient", Patient.class);
		List<Patient> patientList = query.getResultList();
		return patientList;
	}

	/**
	 * This method takes Patient Id and returns the Patient based on Id
	 * 
	 * If the Patient Id is not found then it throw PatientIdNotFound Exception
	 * 
	 * @param patientId - integer value to display patient based on patientId
	 * 
	 */
	@Override
	public Patient viewPatient(int patientId) throws PatientIdNotFoundException {
		Patient patient = entityManager.find(Patient.class, patientId);
		if (patient == null) {
			throw new PatientIdNotFoundException(patientId);
		}
		return patient;
	}

	

	/**
	 * This method begins the Transaction
	 * 
	 */
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	/**
	 * This method commits the Transaction
	 * 
	 */
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	
	/**
	 * This method takes the appointment details and calls the bookAppointment method of AppointmentServiceImpl to add the appointment details to DB
	 * 
	 * @param appointment - appointment entity details
	 * 
	 * Returns appointment object;
	 */
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		appointment = appointmentService.bookAppointment(appointment);
		return appointment;
	}

	
	
	/**
	 * This method takes the appointment Id and returns the corresponding appointment object
	 * 
	 * @param appointmentId - Integer value
	 */
	@Override
	public Appointment viewAppointmentDetails(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment appointment = appointmentService.viewAppointment(appointmentId);
		if (appointment == null) {
			throw new AppointmentIdNotFoundException(appointmentId);
		}
		return appointment;
	}

	
	/**
	 * This method takes the Patient Id and returns the corresponding report object
	 * 
	 * @param patientId - Integer value
	 */
	@Override
	public Report viewReport(int patientId) throws PatientIdNotFoundException {
		Patient patient = entityManager.find(Patient.class, patientId);
		Report report = reportService.viewReport(patient.getReport().getReportId(),patientId); 
		if(report == null) { 
			throw new PatientIdNotFoundException(patientId); 
		} 
		return report; 
	}

	
	/**
	 * This method returns the Tests List present in the Tests Table
	 * 
	 * If Tests list is null, returns null
	 * 
	 * @return list of Tests
	 * 
	 */
	@Override
	public List<Tests> viewAllTests() {
		List<Tests> allTests = testService.viewAllTests();
		return allTests;
	}

}
