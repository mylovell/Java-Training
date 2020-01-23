package com.lf;

public class Person {
	// 构造方法
	public Person() {
		System.out.println("Person - constructor");
	}
	{
		System.out.println("初始化块 - Person - block2");
	}
	static {
		System.out.println("静态初始化块 - Person - static2");
	}
	static {
		System.out.println("静态初始化块 - Person - static1");
	}
	{
		System.out.println("初始化块 - Person - block1");
	}
}
