package com.lf;

public class Person {
	// 类变量
    public static int count = 0;
    // 实例变量
    public int age = 12;
    
    // 类方法
    public static void test2() {System.out.println("类方法test2");}
    // 实例方法
    public void run2() {System.out.println("实例方法run2");}
    
    // 实例方法
    public void run() {
    	System.out.println(count);// 类变量
    	System.out.println(age);// 实例变量
		test2();// 类方法
		run2();// 实例方法
	}
    
    // 类方法
    public static void test1() {
    	System.out.println("类方法test1");
    	
    	// this.age; // 类方法没有 this 这个隐藏参数，报错。
    	
    	// 报错，无法访问 实例变量和实例方法 （也是因为类方法没有 this ）
//    	test1(); // 实例方法
//    	System.out.println(age); // 实例变量
    	
    	// 可访问 实例方法和实例变量，相当于前面加上了 类名.方法名、类名.变量名
    	test2();// 类方法
//    	Person.test2();// 全写，也可以
    	System.out.println(count);// 类变量
//    	System.out.println(Person.count);// 全写，也可以
    }
}

