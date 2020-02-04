
package com.lf.Asserts;

public class Main {

	public static void main(String[] args) {
		Asserts.test(sum(10, 20) == 30);
		Asserts.test(sum(10, 20) == 20);
		Asserts.test(sum(10, 20) == 10);

		// 打印自动定位技术，eclipse的技术
		System.out.println("com.lf.Asserts.Main.main(Main.java:12)");
		System.err.println("com.lf.Asserts.Main.main(Main.java:13)");
		
	}
	
	static int sum(int a, int b) {
		return a + b;
	}

}
