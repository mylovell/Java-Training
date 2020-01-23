package com.lf;

public class Animal {
	
	public final int age = 14;

	public final void eat() {
		age = 15;
		System.out.println("age is " + age);
		System.out.println("Animal eat");
	}
}
