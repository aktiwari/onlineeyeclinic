package com.cg.onlineeyeclinc.dao;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.DoctorIdNotFoundException;

public interface IDoctorRepository {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	Doctor deleteDoctor(int doctorId)throws DoctorIdNotFoundException;
	Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
	
	List<Appointment> viewAppointments();
	Tests createTest(Tests test);
	
	void commitTransaction();
	void beginTransaction();
}
