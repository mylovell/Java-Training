package com.lf;

public class Person {
	
	public static void main(String[] args) 
	{
		try {
			new Person(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// 抛出新建异常
	public Person(String name) throws Exception{
		if (name == null || name.length() == 0) {
			throw new Exception("name must not be empty.");
		}
		
	}

}
