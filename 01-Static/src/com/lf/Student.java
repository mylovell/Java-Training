package com.lf;

public class Student {
	
	public static int count = 10; // 1.声明中
	
	{
		System.out.println("初始化块 - Student - block");
	}
	
	// 2.静态初始化代码块中：
    //当一个类初始化的时候执行该静态初始化块；
    //当一个类第一次主动使用时，JVM会对类初始化。（只执行一次）
	static {
		count = 12;
		System.out.println("静态初始化块 - static2");
	}
	
	// 可以有多个静态初始化块，执行顺序按源码中的顺序
	static {
		System.out.println("静态初始化块 - static1");
	}
	// 构造方法
	public Student() {
		System.out.println("Student - constructor");
	}
}
