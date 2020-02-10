package com.lf;

public class Student {
	
	public static void main(String[] args) {
		System.out.println(Student.classNumber);
	}
	
	static int classNumber = 10;
	
	public Student() {
		classNumber = 20;
	}
	
	static {
		classNumber = 30;
	}

}
