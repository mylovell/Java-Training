package com.lf.TryCatch;

public class Main {

	public static void main(String[] args) {
		
		
		
		test0();
		

	}

	private static void test0() {
		System.out.println(1);
		try {
			System.out.println(2);
			Integer integer = new Integer("abc");
			System.out.println(3);
		} catch (NumberFormatException e) {
			System.out.println(4);
		}
		System.out.println(5);
	}
	
	public static void test1() {
		
//		if (divide(20, 10) == 0) {
//			// 错误处理代码
//		} else {
//			// 正常的逻辑代码
//		}
		
		try {
			// 正常逻辑代码
			int result = divide(20, 0);
		} catch (IllegalArgumentException e) {
			// 必然是错误逻辑代码
		}
		
	}

	static int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("除数不能为0");
		} else {
			return a/b;
		}
	}
	
}
