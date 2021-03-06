package com.lf.regex;

public class Main {

	public static void main(String[] args) {

		
		String regex0 = "[123]";// 匹配集合中的一个即可
		System.out.println("c".matches(regex0));
		System.out.println("1".matches(regex0));
		System.out.println(".".matches(regex0));
		System.out.println("------------------0");
		
		
		String regex = ".";// 预定义字符
		System.out.println("c".matches(regex));//true
		System.out.println("1".matches(regex));//true
		System.out.println(".".matches(regex));//true
		System.out.println("------------------1");
		
		String regex2 = "\\.";// 只匹配点
		System.out.println("c".matches(regex2));
		System.out.println("1".matches(regex2));
		System.out.println(".".matches(regex2));//true
		System.out.println("------------------2");
		
		String regex3 = "\\d";// 预定义字符，匹配所有数字
		System.out.println("d".matches(regex3));
		System.out.println("1".matches(regex3));//true
		System.out.println(".".matches(regex3));
		System.out.println("------------------3");
		
		String regex4 = "\\[123\\]";// 完整匹配给出的所有字符
		System.out.println("c".matches(regex4));
		System.out.println("[123]".matches(regex4));//true
		System.out.println(".".matches(regex4));
		System.out.println("------------------4");
		
	}

}
