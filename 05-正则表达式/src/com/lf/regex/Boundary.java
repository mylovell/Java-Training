package com.lf.regex;

import java.util.regex.Pattern;

public class Boundary {

	public static void main(String[] args) {
		
//		boundary_A_z();
		boundary_A_Z();
	}
	
	public static void boundary_A_z() {
//		String regex = "\\Adog\n\\z";
		String regex = "\\Adog\\z";
		Matcher.findAll(regex, "dog");
		Matcher.findAll(regex, "dog\n");
		Matcher.findAll(regex, "dog\ndog\rdog");
		Matcher.findAll(regex, "dog\ndog\rdog",Pattern.MULTILINE);
		System.out.println("--------------");
		
		
//		System.out.println("dog".matches(regex));
//		System.out.println("dog\n".matches(regex));
//		System.out.println("dog\ndog\rdog".matches(regex));
	}

	public static void boundary_A_Z() {
		String regex = "\\Adog\\Z";
		Matcher.findAll(regex, "dog");
		Matcher.findAll(regex, "dog\n");
		Matcher.findAll(regex, "dog\ndog\rdog");
		Matcher.findAll(regex, "dog\ndog\rdog",Pattern.MULTILINE);
		System.out.println("--------------");
		
	}
}
