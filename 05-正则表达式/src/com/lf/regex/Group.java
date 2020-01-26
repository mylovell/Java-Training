package com.lf.regex;

public class Group {

	public static void main(String[] args) {
		
		group();
//		backreference();
//		backreference2();
	}
	
	public static void group() {
		String regex = "(dog){2}";
		System.out.println("dogdog".matches(regex));// true
		String regex2 = "(dog){2}\\1";
		System.out.println("dogdogdog".matches(regex2));// true
	}
	
	public static void backreference() {
		String regex = "(\\d\\d)\\1";
		System.out.println("3434".matches(regex));// true
		System.out.println("3456".matches(regex));// false
	}
	
	public static void backreference2() {
		String regex = "([a-z]{2})([A-Z]{2})\\2\\1";
		System.out.println("lcPKPKlc".matches(regex));// true
		System.out.println("lyPKPKlc".matches(regex));// false
	}

}
