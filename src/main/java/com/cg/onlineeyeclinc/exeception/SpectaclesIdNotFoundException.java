package com.cg.onlineeyeclinc.exeception;

public class SpectaclesIdNotFoundException extends Exception {

	/**This is user defined Exception class for spectaclesId not found
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public SpectaclesIdNotFoundException(int spectaclesId) {
		this.id = spectaclesId;
	}
	
	@Override
	public String toString() {
		return "spectacles with Id "+id+" is not Found";
	}
}