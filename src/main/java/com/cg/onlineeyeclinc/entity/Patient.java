package com.cg.onlineeyeclinc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/** This is an entity class for Patient with getters and setters and Parametrized constructor
 * 
 * @author Prudhvi Mypati
 *
 */


@Entity
@Table(name="Patient")
public class Patient {
	
	/** 
	 * Data Fields
	 */
	
	@Id
	@Column(length=10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	@Column(length=15)
	private String patientName;
	@Column(length=10)
	private int patientAge;
	@Column(length=10)
	private long patientMobile;
	@Column(length=20)
	private String patientEmail;
	@Column(length=10)
	private LocalDate patientDOB;
	@Column(length=15)
	private String patientUserName;
	@Column(length=15)
	private String patientPassword;
	@Column(length=30)
	private String patientAddress;
	
	
	@OneToOne(targetEntity = Appointment.class, fetch = FetchType.EAGER)
	private Appointment appointment ;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private Report report;
	
	public Patient() {
	}

	/** This is an Parametrized constructor for Patient Class to initialize the Patient details
	 * 
	 */

	public Patient(String patientName, int patientAge, long patientMobile, String patientEmail,
			LocalDate patientDOB, String patientUserName, String patientPassword, String patientAddress) {
		super();
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.patientUserName = patientUserName;
		this.patientPassword = patientPassword;
		this.patientAddress = patientAddress;
		System.out.println("Patient details are intialized");
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Patient [Patient Id=" + patientId + "\n Patient Name=" + patientName + "\n Patient Age=" + patientAge
				+ "\n Patient Mobile=" + patientMobile + "\n Patient Email=" + patientEmail + "\n Patient DOB=" + patientDOB
				+ "\n Patient UserName=" + patientUserName + "\n Patient Password=" + patientPassword + "\n Patient Address="
				+ patientAddress +"]";
	}
	
	
	
}
