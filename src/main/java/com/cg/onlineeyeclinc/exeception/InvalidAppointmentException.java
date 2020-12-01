package com.cg.onlineeyeclinc.exeception;

public class InvalidAppointmentException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidAppointmentException(String message)
	{
		super(message);
	}

}
