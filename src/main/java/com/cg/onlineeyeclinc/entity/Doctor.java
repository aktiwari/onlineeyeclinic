package com.cg.onlineeyeclinc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** This is entity class for patients with default constructor, parameterized constructor along with getters and setters
 * 
 * @author Kondraju Praneeth
 * @version 1.0
 *
 */

@Entity
@Table(name = "Doctor")
public class Doctor {
	
	/**
	 * Data Fields
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	private String doctorName;
	private String doctorConsultationTime;
	private long doctorMobile;
	private String doctorEmail;
	private String userName;
	private String password;
	private String address;
	
	/**
	 * Default Constructor
	 */
	
	public Doctor() {

	}
	
	/**
	 * Parameterized Constructor
	 */

	public Doctor(String doctorName, String doctorConsultationTime, long doctorMobile, String doctorEmail,
			String userName, String password, String address) {
		super();
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	/**
	 * Getters and setters for All data fields
	 * 
	 */

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}

	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}

	public long getDoctorMobile() {
		return doctorMobile;
	}

	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorConsultationTime="
				+ doctorConsultationTime + ", doctorMobile=" + doctorMobile + ", doctorEmail=" + doctorEmail
				+ ", userName=" + userName + ", password=" + password + ", address=" + address + "]";
	}
	

}
