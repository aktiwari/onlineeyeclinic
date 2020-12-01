package com.cg.onlineeyeclinc.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.ReportIdNotFoundException;
/**The ReportRepositoryImpl class provides methods to persist the data or update or remove or view from database
 * 
 * @author D,Pradeep kumar
 *
 */

public  class ReportRepositoryImpl implements IReportRepository {

	private EntityManager entityManager;
	

	public ReportRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
		
	}
	
	/**
	 * This method takes report object and store doctor details in DB
	 * @param report - report entity details 
	 */
	@Override

	public Report addReport(Report report) {
		entityManager.persist(report);
		return report;
	}
	/**
	 * This method takes report object and update report details in DB
	 * @param report - doctor entity details 
	 */

	@Override
	public Report updateReport(Report report){
	entityManager.merge(report);
		return report;
		
	}
	/**
	 * This method takes report object and remove report details in DB
	 * @param report - report entity details 
	 */

	@Override

	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		Report rep = entityManager.find(Report.class, reportId);
		if(rep==null) {
			throw new ReportIdNotFoundException(reportId);
		}
		entityManager.remove(rep);
		rep=null;
		return rep;
	}

	/**
	 * This method takes reportId parameter and report report details from DB
	 * @param reportId - integer value to display report based on reportId
	 * @return Report Object
 */
	@Override
	public Report viewReport(int reportId,int patientId) throws ReportIdNotFoundException, PatientIdNotFoundException {
		Report rep= entityManager.find(Report.class, reportId);
		Report report = null;
		if(rep==null) {
			throw new ReportIdNotFoundException(patientId);
		}
		if(rep.getPatient().getPatientId() == patientId) {
			report = rep;
		}
		return report;
		
		
	}
	/**
	 * This method is used to fetch all report details from DB
	 * @return list of reports
	 */
	@Override
	public List<Report> viewAllReport(LocalDate date) {
		TypedQuery<Report> t =entityManager.createQuery("select t from  Report t ", Report.class);
		List<Report> allReport= t.getResultList();
		return allReport;
	}

	
	
	/**
	 * This method is used to begin the transaction.
	 */

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	
	/**
	 * This method is used to commit transaction.
	 */

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();	
	}
	/**
	 * This method is used to fetch all report details from DB
	 * 
	 * @return list of reports
	 */
	
	@Override
	public List<Spectacles> viewSpectacles() {
		TypedQuery<Spectacles> query = entityManager.createQuery("select a from Spectacles a", Spectacles.class);
		List<Spectacles> allSpectacles = query.getResultList();
		return allSpectacles;
	}

	}
	
	



