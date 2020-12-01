package com.cg.onlineeyeclinc.exeception;

public class AppointmentIdNotFoundException extends Exception {
	/**This is user defined Exception class for PatientId not found
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public AppointmentIdNotFoundException(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Appointment with Id "+id+" is not Found";
	}
}
