package com.lf.regex;

public class Group {

	public static void main(String[] args) {
		
//		group();
//		backreference();
		backreference2();
	}
	
	public static void group() {
		String regex = "(dog){2}";
		System.out.println("dogdog".matches(regex));
	}
	
	public static void backreference() {
		String regex = "(\\d\\d)\\1";
		System.out.println("3434".matches(regex));
	}
	
	public static void backreference2() {
		String regex = "([a-z]{2})([A-Z]{2})\\2\\1";
		System.out.println("lcPKPKlc".matches(regex));
	}

}
