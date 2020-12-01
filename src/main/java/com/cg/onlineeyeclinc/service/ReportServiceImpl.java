/**
 * 
 */
package com.cg.onlineeyeclinc.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyeclinc.dao.IReportRepository;
import com.cg.onlineeyeclinc.dao.ReportRepositoryImpl;
import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.ReportIdNotFoundException;

/**
 * 
 * @author PradeepumarD
 *
 */
public class ReportServiceImpl implements IReportService {
	private IReportRepository dao;
	/** Constructor to get the object of ReportRepositoryImpl */
	public ReportServiceImpl() {
		dao = new ReportRepositoryImpl();
	}
	/**
	 * This method Add Patient by calling the addReport method of Repository layer
	 * and returns the added Report object
	 * 
	 * @param report - report entity details
	 * 
	 */
@Override
	public Report addReport(Report report) {
		dao.beginTransaction();
		report = dao.addReport(report);
		dao.commitTransaction();
		return report;
	}

/**
 * This method updates the booking details by calling the updateReport method of
 * Repository layer and returns the updated Report object
 * 
 * Updates the Report object if the Patient id is present in the Database and
 * returns the updated Report object
 * 
 * If the Report Id is not found then it throw ReportIdNotFound Exception then
 * the catch part is executed and patient is made null and prints the exception
 * statement and returns null
 * 
 * @param Report - report entity details
 * 
 */
	public Report updateReport(Report report) {
		dao.beginTransaction();
		dao.updateReport(report);
		dao.commitTransaction();
		return report;

	}
	/**
	 * This method deletes the Report object by calling the deleteReport method of
	 * Repository layer and returns null
	 * 
	 * If the Report Id is not found and ReportIdNotFound Exception is thrown then
	 * the catch part is executed and prints the exception statement and returns
	 * null
	 * 
	 * @param report - reportId - integer value to delete
	 * 
	 */
	
	public Report removeReport(int reportId) {
		dao.beginTransaction();
		Report report = null;
		try {
			report=dao.removeReport(reportId);
			dao.removeReport(reportId);
		} catch (ReportIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.commitTransaction();
		return report;

	}

	/**
	 * This method returns the Report List present in the Report Table
	 * 
	 * If report list is null, returns null
	 * 
	 * @return vieweport
	 * 
	 */
	  public Report viewReport(int reportId, int patientId) {
		  Report rep=null;
		  try {
			  try {
				rep=dao.viewReport(reportId, patientId);
			} catch (PatientIdNotFoundException e) {
				
				e.printStackTrace();
			}
		  } catch(ReportIdNotFoundException e) {
		  System.out.println(e);
		  }
	  return rep;
	  }
	  /**
		 * This method returns the Report List present in the Report Table
		 * 
		 * If report list is null, returns null
		 * 
		 * @return list of report
		 * 
		 */

	public List<Report> viewAllReport(LocalDate date) {
		// TODO Auto-generated method stub
		List<Report> allReport = dao.viewAllReport(date);
		return allReport;
	}
	
	/**
	 * This method returns the Report List present in the Report Table
	 * 
	 * If report list is null, returns null
	 * 
	 * @return list of report
	 * 
	 */

	@Override
	public List<Spectacles> viewSpectacles() {
		List<Spectacles> specList = dao.viewSpectacles();
		return specList;
	}

}
