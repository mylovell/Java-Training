package com.lf.regex;

import java.util.regex.Pattern;

public class Matcher {

	public static void main(String[] args) {
		
//		findAll("\\d+", "_123_456789_");
//		findAll("\\?d{3}", "_123_456789_");
//		test_Greedy_Reluctant_Possessive();
//		matcher1();
//		matcher2();
		matcher3();
	}
	
	
	public static void test_Greedy_Reluctant_Possessive() {
		
		String input = "afooaafoooaaaafooa";
		
		// 贪婪，"afooaafoooaaaafoo",[0,17)
//		findAll(".*foo", input);System.out.println("----------------1");
//		findAll("afo\\d*", "afo22afoooaaaafooa");System.out.println("----------------1.2");
		
		System.out.println("afo\\d".matches("afo1"));
		findAll("afo\\d", "afo1");
		
		
		// 勉强
		// "afoo",[0,4)
		// "aafoo",[4,9)
		// "oaaaafoo",[9,17)
//		findAll(".*?foo", input);System.out.println("----------------2");
//		
//		// 独占
//		// No match.
//		findAll(".*+foo", input);System.out.println("----------------3");
//		
//		// .*+ 貌似只有放在最后才有用
//		findAll("afo.*+", input);System.out.println("----------------4");
		
	}
	
	
	// 封装
	public static void findAll(String regex, String input) {
		findAll(regex, input, 0);
	}
	
	public static void findAll(String regex, String input, int flags) {
		if (regex == null || input == null)  return;
		
		Pattern p = Pattern.compile(regex, flags);
		java.util.regex.Matcher m = p.matcher(input);
		
		boolean found = false;
		while (m.find()) {// 循环匹配子串
			found = true;
			System.out.format("\"%s\",[%d,%d)%n",m.group(),m.start(),m.end());
		}
		if (!found) {
			System.out.println("No match.");
		}
	}
	
	static void matcher1() {
		String input = "a";
//		findAll("a?", input);
//		findAll("a*", input);
//		findAll("a+", input);
	}

	static void matcher2() {
		String input = "afooaaaaaafooa";
		findAll(".*foo", input);
		findAll(".*?foo", input);
		findAll(".*+foo", input);
	}
	
	static void matcher3() {
		String input = "afooaaaaaafoo";
		findAll(".*foo", input);// "afooaaaaaafoo",[0,13)
		findAll(".*?foo", input);
		findAll(".*+foo", input);// No match.
		findAll("afo.*+", input);// "afooaaaaaafoo",[0,13)
	}
	
}
