package com.lf.String;

public class Main {

	public static void main(String[] args) {
		
		test1();
		
		
		
		
	}

	private static void test1() {
		String s1 = "mj";
		String s2 = new String("mj");
		String s3 = new String(s1);
		String s4 = new String(s2);
		
		byte[] cs = {'m','j'};
		String s5 = new String(cs);
		String s6 = new String(s5);
		
		String s7 = s6.intern();

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s4);
		System.out.println(s2 == s4);
		
	}

}
