package com.lf;

public class Main {

	public static void main(String[] args) {
		//Rocket rocket = new Rocket(); // 报错，外界不能创建实例
		
		System.out.println(Rocket.getInstance());
		System.out.println(Rocket.getInstance());
		
		Rocket r1 = Rocket.getInstance();
		Rocket r2 = Rocket.getInstance();
		System.out.println(r1==r2);
		
	}

}
