package com.cg.onlineeyeclinc.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyeclinc.entity.Report;
import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.PatientIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.ReportIdNotFoundException;

public interface IReportService {
	Report addReport(Report report);

	Report updateReport(Report report);

	Report removeReport(int reportId)throws ReportIdNotFoundException;

	Report viewReport(int reportId, int patientId)throws ReportIdNotFoundException,PatientIdNotFoundException;

	List<Report> viewAllReport(LocalDate date);

	List<Spectacles> viewSpectacles();



}
