package com.lf.regexTool;

import java.util.regex.Pattern;

/**
 * 正则匹配
 * 1、匹配整体——matches()；
 * 2、匹配子串 findAll()————匹配模式【贪婪、勉强?、独占+；单行(?s)、多行(?m)、不分大小写(?!)】；
 * 3、字符串替换————替换所有子串、替换找到的第一个
 * @author fengluo
 *
 */
public class RegexTool {

//	public static void main(String[] args) {
//		String input = "abcwwabcwwasdwwa";
//		String replacement = "YY";
//		System.out.println( replaceAll("w{2}", input, replacement));
//		System.out.println( replaceFirst("w{2}", input, replacement));
//		System.out.println( replaceLast("w{2}", input, replacement));
//		System.out.println( replaceN("w{2}", input, replacement, 1));
//		System.out.println("-------------");
//		System.out.println( RegexTool.matches("w{2}", input));
//		findAll("w{2}", input);
//	}
	

	/**
	 * 有原生方法，匹配整体
	 */
	public static boolean matches(String regex, String input) {
		return input.matches(regex);
	}

	
	/**
	 * 匹配所有子串，无模式
	 * @param regex 正则表达式
	 * @param input 字符串
	 */
	public static void findAll(String regex, String input) {
		findAll(regex, input, 0);
	}
	
	/**
	 * 匹配所有子串
	 * @param regex 正则表达式
	 * @param input 被匹配字符串
	 * @param flags	Pattern.DOTALL、Pattern.MULTILINE、Pattern.CASE_INSENSITIVE
	 */
	private static void findAll(String regex, String input, int flags) {
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
	
	/** 
	 * 有原生方法，替换所有子串
	 */
	public static String replaceAll(String regex, String input, String replacement) {
		return input.replaceAll(regex, replacement);
	}
	
	/**
	 * 有原生方法，替换找到的第一个
	 */
	public static String replaceFirst(String regex, String input, String replacement) {
		return input.replaceFirst(regex, replacement);
	}
	
	/**
	 * 替换找到的最后一个
	 */
	public static String replaceLast(String regex, String input, String replacement) {
		
		if (regex == null || input == null)  return null;

		Pattern p = Pattern.compile(regex, 0);
		java.util.regex.Matcher m = p.matcher(input);
		
		int start = 0;
		int end = 0;
		while (m.find()) {// 循环匹配子串
			//System.out.format("\"%s\",[%d,%d)%n",m.group(),m.start(),m.end());
			start = m.start();
			end = m.end();
		}
		
		if (end != 0) {
			StringBuilder sb = new StringBuilder(input);
			sb.replace(start, end, replacement);
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 替换找到的第N个
	 * @param index 从1开始
	 */
	public static String replaceN(String regex, String input, String replacement, int index) {
		
		if (regex == null || input == null) return null;
		if (index < 1) { System.err.println("index必须从1开始 (RegexTool.java:106)");return null;}

		Pattern p = Pattern.compile(regex, 0);
		java.util.regex.Matcher m = p.matcher(input);
		
		int start = 0;
		int end = 0;
		while (m.find()) {// 循环匹配子串
			//System.out.format("\"%s\",[%d,%d)%n",m.group(),m.start(),m.end());
			start = m.start();
			end = m.end();
			if ((--index) == 0) break;
		}
		
		if (end != 0 && index == 0) {
			StringBuilder sb = new StringBuilder(input);
			sb.replace(start, end, replacement);
			return sb.toString();
		}
		return null;
	}
	
	
	
}
