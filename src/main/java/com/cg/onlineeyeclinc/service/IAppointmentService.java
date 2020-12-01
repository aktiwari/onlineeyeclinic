package com.cg.onlineeyeclinc.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyeclinc.entity.Appointment;

public interface IAppointmentService{
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment);
	Appointment cancelAppointment(int appointmentId);
	Appointment viewAppointment(int appointmentId);
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
}
