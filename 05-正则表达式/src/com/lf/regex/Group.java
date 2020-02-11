package com.lf.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group {

	public static void main(String[] args) {
		
//		group();
//		backreference();
//		backreference2();
//		group2();
		group3();
		
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
	
	static void group2() {
		String input = "aa11+bb23-mj33*dd44/5566%ff77";
		String regex = "([a-z])\\1(\\d)\\2";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
	
	static void group3() {
		String input = "aa12+bb34-mj56*dd78/9900";
		String regex = "[a-z]{2}\\d(\\d)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			System.out.println(m.group(1));
		}
	}
	

}
