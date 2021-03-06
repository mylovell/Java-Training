package com.lf.regex;

import java.util.regex.Pattern;

public class DOTALL {

	public static void main(String[] args) {
		
		CASE();
	}
	
	public static void CASE() {
		
		String regex = ".";
		String input = "\r\n";
		Matcher.findAll(regex, input);
		System.out.println("----------------1");
		
		
		Matcher.findAll(regex, input, Pattern.DOTALL);//DOTALL模式下，点号可以匹配终止符
//		"
//		",[0,1) 回车符\r的打印形式
//		"
//		",[1,2) 换行符\n的打印形式
		System.out.println("----------------2");
		
		
		Matcher.findAll(regex, input, Pattern.MULTILINE);
		System.out.println("----------------3");
		
		Matcher.findAll(regex, input, Pattern.MULTILINE | Pattern.DOTALL);
		System.out.println("----------------4");
		
		Matcher.findAll("(?sm).", input);
		System.out.println("----------------5");
	}

}
