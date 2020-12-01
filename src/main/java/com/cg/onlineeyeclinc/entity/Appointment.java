package com.cg.onlineeyeclinc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appointmentId;
	@Column
	private LocalDate dateOfAppointment;
	@Column
	private LocalTime timeOfAppointment;
	@Column
	private double consultationFee;
	
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy="appointment")
	private Patient patient;
public Appointment()
{
	
}
public Appointment(LocalDate dateOfAppointment, LocalTime timeOfAppointment, double consultationFee)
{
	super();
	this.dateOfAppointment = dateOfAppointment;
	this.timeOfAppointment = timeOfAppointment;
	this.consultationFee = consultationFee;
}

public int getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}
public LocalDate getDateOfAppointment() {
	return dateOfAppointment;
}
public void setDateOfAppointment(LocalDate dateOfAppointment) {
	this.dateOfAppointment = dateOfAppointment;
}
public LocalTime getTimeOfAppointment() {
	return timeOfAppointment;
}
public void setTimeOfAppointment(LocalTime timeOfAppointment) {
	this.timeOfAppointment = timeOfAppointment;
}
public double getConsultationFee() {
	return consultationFee;
}
public void setConsultationFee(double consultationFee) {
	this.consultationFee = consultationFee;
}

public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}

@Override
public String toString() {
	return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment="+dateOfAppointment+", timeOfAppointment="+timeOfAppointment+", consultationFee="+consultationFee+"]";
}

}