package com.lf;

public class Main {

	/*
	 * final : 可修饰 类、方法、变量；(个人认为这是个权限控制关键字)
	 * 类  被final修饰：不能子类化、不能被继承；
	 * 方法 被final修饰：不能被重写；
	 * 变量 被final修饰：只能进行1次赋值；
	 */
	
	public static void main(String[] args) {
		
		// Exception in thread "main" java.lang.VerifyError: 
		// class com.lf.Cat overrides final method com.lf.Animal.eat()V
//		Cat cat = new Cat();
//		cat.eat();
		
//		Animal animal = new Animal();
//		animal.eat();
		
	}
	
	

	
}
