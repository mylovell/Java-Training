package com.lf;

public class Person {
	private int age = 12; // 内部静态嵌套类不能访问外部实例变量，因为静态嵌套类内部不会被传入实例。
	private static int count = 1;
	private static void run() {
		System.out.println("Person - run");
	}
	
	public static class Car {
		public void log() {
			// 静态嵌套类可以直接访问外部类中的成员（内部类的特殊权限）
			Person.count = 2;
			Person.run();
			run(); // 父类的静态方法
			System.out.println("Car - Log " + count);
		}
	}
}
