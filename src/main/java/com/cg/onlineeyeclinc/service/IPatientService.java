package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Tests;


/** IPatientService interface provides abstract methods to Add Patient, remove Patient, view Patient, view all Patient, update Patient, book appointment, view Appointment and view report
 * 
 * @author Prudhvi Mypati
 * 
 * 
 */


public interface IPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId);
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId);
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid);
	Report viewReport(int patientId);
	List<Tests> viewAllTests();
}
