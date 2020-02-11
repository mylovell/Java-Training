package com.lf;

public class Main {

	public static void main(String[] args) {
		
		EmptyNameException e = new EmptyNameException();
		try {
			throw e;
		} catch (EmptyNameException e1) {
			e1.printStackTrace();
		}
		
	}

}
