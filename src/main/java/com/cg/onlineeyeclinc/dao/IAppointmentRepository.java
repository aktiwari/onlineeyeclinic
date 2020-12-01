package com.cg.onlineeyeclinc.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.InvalidAppointmentException;

public interface IAppointmentRepository {
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException;
	Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
	void beginTransaction();
	void commitTransaction();
}
