package com.cg.onlineeyeclinc.exeception;

public class PatientIdNotFoundException extends Exception {
	
	/**This is user defined Exception class for PatientId not found
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public PatientIdNotFoundException(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Patient with Id "+id+" is not Found";
	}
}
