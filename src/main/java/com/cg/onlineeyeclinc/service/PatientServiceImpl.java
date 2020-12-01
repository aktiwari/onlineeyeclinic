package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.dao.IPatientRepository;
import com.cg.onlineeyeclinc.dao.PatientRepositoryImpl;
import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;


/** PatientServiceImpl class provides methods to Add Patient, remove Patient, view Patient, view all Patient, update Patient, book appointment, view Appointment and view report
 * 
 * @author Prudhvi Mypati
 * 
 */



public class PatientServiceImpl implements IPatientService {

	private IPatientRepository dao;
	
	/** Constructor to get the object of PatientRepositoryImpl */
	public PatientServiceImpl() {
		dao = new PatientRepositoryImpl();
	}
	
	
	/** This method Add Patient by calling the addPatient method of Repository layer and returns the added Patient object
	 * 
	 * @param patient - patient entity details
	 * 
	 * */
	@Override
	public Patient addPatient(Patient patient) {
		dao.beginTransaction();
		patient = dao.addPatient(patient);
		dao.commitTransaction();
		return patient;
	}

	
	/** This method updates the booking details by calling the updatePatient method of Repository layer and returns the updated Patient object
	 * 
	 * Updates the Patient object if the Patient id is present in the Database and returns the updated Patient object
	 * 
	 * If the Patient Id is not found then it throw PatientIdNotFound Exception then the catch part is executed and patient is made null and prints the exception statement and returns null
	 * 
	 * @param patient - patient entity details
	 * 
	 * */
	@Override
	public Patient updatePatient(Patient patient) {
		dao.beginTransaction();
		try {
			patient = dao.updatePatient(patient);
		} catch (PatientIdNotFoundException e) {
			patient = null;
			System.out.println(e);
		}
		dao.commitTransaction();
		return patient;
	}
	
	
	/** This method deletes the patient object by calling the deletePatient method of Repository layer and returns null
	 * 
	 * If the Patient Id is not found and PatientIdNotFound Exception is thrown then the catch part is executed and prints the exception statement and returns null
	 * 
	 *  @param patient - patientId - integer value to delete
	 * 
	 * */
	@Override
	public Patient deletePatient(int patientId){
		dao.beginTransaction();
		Patient patient = null;
		try {
			patient = dao.deletePatient(patientId);
		} catch (PatientIdNotFoundException e) {
			System.out.println(e);
		}
		dao.commitTransaction();
		return patient;
	}

	
	/** This method returns the Patient List present in the Patient Table
	 *  
	 *  If patient list is null, returns null
	 *  
	 * @return list of patients
	 *  
	 * */
	@Override
	public List<Patient> viewPatientList() {
		List<Patient> patient = dao.viewPatientList();
		return patient;
	}

	
	/** This method takes Patient Id and returns the Patient based on Id
	 * 
	 *  If the Patient Id is not found and PatientIdNotFound Exception is thrown then the catch part is executed and prints the exception statement and returns null
	 *  
	 *  @param patientId - integer value to display patient based on patientId
	 * */
	@Override
	public Patient viewPatient(int patientId) {
		Patient patient = null;
		try {
			patient = dao.viewPatient(patientId);
		} catch (PatientIdNotFoundException e) {
			System.out.println(e);
		}
		return patient;
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
		appointment = dao.bookAppointment(appointment);
		return appointment;
	}


	/**
	 * This method takes the appointment Id and returns the corresponding appointment object
	 * 
	 * @param appointmentId - Integer value
	 */
	@Override
	public Appointment viewAppointmentDetails(int appointmentid) {
		Appointment appointment = null;
		try {
			appointment = dao.viewAppointmentDetails(appointmentid);
		} catch (AppointmentIdNotFoundException e) {
			System.out.println(e);
		}
		return appointment;
	}


	/**
	 * This method takes the Patient Id and returns the corresponding report object
	 * 
	 * @param patientId - Integer value
	 */
	@Override
	public Report viewReport(int patientId) {
		Report report = null;
		try {
			report = dao.viewReport(patientId);
		} catch (PatientIdNotFoundException e) {
			System.out.println(e);
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
		List<Tests> allTests = dao.viewAllTests();
		return allTests;
	}


}
