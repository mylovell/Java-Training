package com.lf.regex;

public class Quantifier {

	public static void main(String[] args) {
		
		String regex = "76{2}";
		System.out.println("76".matches(regex));
		System.out.println("766".matches(regex));//true
		System.out.println("76666".matches(regex));
		System.out.println("-------------------");
		
		String regex2 = "76{2}?";// 不懂
		System.out.println("7".matches(regex2));
		System.out.println("76".matches(regex2));
		System.out.println("766".matches(regex2));//true
		System.out.println("76666".matches(regex2));
		System.out.println("-------------------2");
		
		String regex3 = "76{2}+";// 不懂
		System.out.println("7".matches(regex3));
		System.out.println("76".matches(regex3));
		System.out.println("766".matches(regex3));//true
		System.out.println("76666".matches(regex3));
		System.out.println("-------------------3");
		
	}

}
