package com.cg.onlineeyeclinc.exeception;

public class DoctorIdNotFoundException extends Exception {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public DoctorIdNotFoundException(int id) {
	System.out.println(id + " Not Found");
}
//public DoctorIdNotFoundException(String message) {
//	super(message);
//}
}
