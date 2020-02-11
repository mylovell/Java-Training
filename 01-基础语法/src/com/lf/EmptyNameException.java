package com.lf;

public class EmptyNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyNameException() {
		super("name must not be empty");
	}
	

}
