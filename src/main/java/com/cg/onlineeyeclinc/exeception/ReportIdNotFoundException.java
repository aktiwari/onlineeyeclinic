package com.cg.onlineeyeclinc.exeception;

public class ReportIdNotFoundException extends Exception {
	/**This is user defined Exception class for reportId not found
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public ReportIdNotFoundException(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "report with Id "+id+" is not Found";
	}
}
