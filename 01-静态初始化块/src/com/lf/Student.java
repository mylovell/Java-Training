package com.lf;

public class Student extends Person {
	// 构造方法
	public Student() {
		System.out.println("Student - constructor");
	}
	{
		System.out.println("初始化块 - Student - block2");
	}
	static {
		System.out.println("静态初始化块 - Student - static2");
	}
	static {
		System.out.println("静态初始化块 - Student - static1");
	}
	{
		System.out.println("初始化块 - Student - block1");
	}
}
