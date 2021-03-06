package com.lf;

public class TestLocalClass {
	private int a = 1;
	private static int b = 2;
	private static void test1() {}
	private void test2() {}
	
	// 方法
	public void test3() {
		int c = 2;
		
		// 局部类
		class LocalClass {
			static final int d = 4;
			void test4() {
				System.out.println(a + b + c + d);
				test1();
				test2();
			}
		}
		
		new LocalClass().test4(); // 9
	}

}
