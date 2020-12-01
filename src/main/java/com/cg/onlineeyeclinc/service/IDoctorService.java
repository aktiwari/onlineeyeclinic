package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;

public interface IDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	Doctor deleteDoctor(int doctorId);
	Doctor viewDoctor(int doctorId);
	List<Doctor> viewDoctorsList();
	List<Appointment> viewAppointments();
	Tests createTest(Tests test);
}
