package com.cg.onlineeyeclinc.dao;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Patient;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;


/** IPatientRepository interface provides abstract methods to Add Patient, remove Patient, view Patient, view all Patient, update Patient, book appointment, view Appointment and view report
 * 
 * @author Prudhvi Mypati
 * 
 */



public interface IPatientRepository {
	
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient)throws PatientIdNotFoundException;
	Patient deletePatient(int patientId)throws PatientIdNotFoundException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId)throws PatientIdNotFoundException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid)throws AppointmentIdNotFoundException;
	Report viewReport(int patientId)throws PatientIdNotFoundException;
	List<Tests> viewAllTests();
	void beginTransaction();
	void commitTransaction();
}
