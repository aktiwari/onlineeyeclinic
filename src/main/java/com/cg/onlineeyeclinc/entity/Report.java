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

/**
 * This is entity class for reports with default constructor, parameterized
 * constructor along with getters and setters
 * 
 * @author D,Pradeep kumar
 * @version 1.0
 *
 */

@Entity
@Table(name = "Report")
public class Report {
	public static final String LocalDate = null;
	/**
	 * Data Fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	private int reportId;
	@Column(length=10)
	private LocalDate dateOfReport;
	@Column(length=10)
	private String descriptionOfReport;
	@Column(length=10)
	private String visualAcuity;
	@Column(length=10)
	private String visualAcuityNear;
	@Column(length=10)
	private String visualAcuityDistance;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "report")
	private Patient patient;

	/**
	 * Default Constructor
	 */

	public Report() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized Constructor
	 */

	public Report(LocalDate dateOfReport, String descriptionOfReport, String visualAcuity, String visualAcuityNear,
			String visualAcuityDistance) {
		super();
		this.dateOfReport = dateOfReport;
		this.descriptionOfReport = descriptionOfReport;
		this.visualAcuity = visualAcuity;
		this.visualAcuityNear = visualAcuityNear;
		this.visualAcuityDistance = visualAcuityDistance;
	}

	/**
	 * Getters and setters for All data fields
	 * 
	 */
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDate getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(LocalDate dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}

	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}

	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}

	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Report [reportId= " + reportId + ", dateofReport=" + dateOfReport + ", descriptionOfReport="
				+ descriptionOfReport + ", visualAcuity=" + visualAcuity + ", visualAcuityNear=" + visualAcuityNear
				+ ", visualAcuityDistance=" + visualAcuityDistance + "]";
	}

}
