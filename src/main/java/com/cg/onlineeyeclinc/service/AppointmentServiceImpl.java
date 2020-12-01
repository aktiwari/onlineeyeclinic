package com.cg.onlineeyeclinc.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyeclinc.dao.AppointmentRepositoryImpl;
import com.cg.onlineeyeclinc.dao.IAppointmentRepository;
import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.InvalidAppointmentException;
/**
 * 
 * @author N,Nandini
 *
 */
public class AppointmentServiceImpl implements IAppointmentService {
     private IAppointmentRepository dao;
 
     public AppointmentServiceImpl() {
	     dao = new AppointmentRepositoryImpl();
	     
     }
     @Override
     public Appointment bookAppointment(Appointment appointment) {
    	 //dao.beginTransaction();
	     appointment=dao.bookAppointment(appointment);
	     //dao.commitTransaction();
	     return appointment;
	     
     }
     @Override
     public Appointment updateAppointment(Appointment appointment) {
    	 
    	 dao.beginTransaction();
	     try {
			appointment=dao.updateAppointment(appointment);
		} catch (InvalidAppointmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     dao.commitTransaction();
	     return appointment;
     }
     @Override
     public Appointment cancelAppointment(int appointmentId) {
    	 dao.beginTransaction();
    	 Appointment appointment=null;
	     try {
			appointment=dao.cancelAppointment(appointmentId);
		} catch (AppointmentIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     dao.commitTransaction();
	     return appointment;
     }
     @Override
     public Appointment viewAppointment(int appointmentId)  {
    	 Appointment appointment=null;
	     try {
			appointment=dao.viewAppointment(appointmentId);
		} catch (AppointmentIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return appointment;
     }
     @Override
     public List<Appointment> viewAppointments(LocalDate date) {
    	 List<Appointment> appByDate = dao.viewAppointments(date);
    	  return appByDate;
     }
	public List<Appointment> viewAllAppointments() {
		List<Appointment> allAppointments = dao.viewAllAppointments();
		return allAppointments;
	}
	
 }
