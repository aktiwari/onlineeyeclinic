package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.dao.DoctorRepositoryImpl;
import com.cg.onlineeyeclinc.dao.IDoctorRepository;
import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.entity.Doctor;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.DoctorIdNotFoundException;

public class DoctorServiceImpl implements IDoctorService{
	
private IDoctorRepository dao;

public Tests tests = new Tests();
	
	public DoctorServiceImpl() {
		dao = new DoctorRepositoryImpl();
	}
	

	@Override
	public Doctor addDoctor(Doctor doctor) {
		dao.beginTransaction();
		doctor = dao.addDoctor(doctor);
		dao.commitTransaction();
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		dao.beginTransaction();
		doctor = dao.updateDoctor(doctor);
		dao.commitTransaction();
		return doctor;
	}

	@Override
	public Doctor deleteDoctor(int doctorId) { 
		Doctor doc = null;
		dao.beginTransaction();
		
		try {
			doc = dao.deleteDoctor(doctorId);
		} catch (DoctorIdNotFoundException e) {
			System.out.println(e);
		}
		
		dao.commitTransaction();
		
		return doc;
	}

	@Override
	public Doctor viewDoctor(int doctorId) {
		Doctor doc = null;
		try {
			doc = dao.viewDoctor(doctorId);
		} catch (DoctorIdNotFoundException e) {
			System.out.println(e);
		}
		return doc;
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		List<Doctor> allDoctors = dao.viewDoctorsList();
		return allDoctors;
	
	}


	@Override
	public List<Appointment> viewAppointments() {
		List<Appointment> allAppointments = dao.viewAppointments();
		return allAppointments;
	}


	@Override
	public Tests createTest(Tests test) {
		test = dao.createTest(test);
		return test;
	}

}
