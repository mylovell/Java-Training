package com.lf;

public class Main {

	public static void main(String[] args) {
		
		Eatable eatable = 
		new Eatable() {
			
			@Override
			public String name() {
				return "rice";
			}
			
			@Override
			public int energy() {
				return 90;
			}
			
			@Override
			public void say() {
				System.out.println("happy happy !");
			}
		};
//		.say();
		
		System.out.println(eatable.name() + eatable.energy());
		
	}

}
