package com.lf.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String类与正则表达式 {

	public static void main(String[] args) {
		
//		basicMethodUse();
//		replaceWord();
//		replaceNumbers();
//		splitByNumbers();
//		backReference();
		backReference2();
		
//		String input = "aa12+b34-lf56*dd78/x100";
//		String regex = "([a-z])[a-z&&[^\\\1]]";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(input);
//		while (m.find()) {
//			// [aa12, lf56, dd78, xy00]
//			System.out.println(m.group()+" _ "+m.group(1));
//			// [2, 6, 8, 0]
////			System.out.println(m.group(1));
//		}
		
	}

	// "ab12"，取出末尾的 2
	private static void backReference2() {
		String input = "aa12+bd34-lf56*dd78/9900";
		String regex = "[a-z]{2}\\d(\\d)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			// [aa12_2, bd34_4, lf56_6, dd78_8]
			System.out.println(m.group() + "_" + m.group(1));
		}
		
	}

	// aa11，提取 a和1 。
	private static void backReference() {
		String input = "aa11+bb23-lf33*dd44/5566%ff77";
		String regex = "([a-z])\\1(\\d)\\2";//aa11 - [字母][字母][数字][数字]
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			// [aa11, dd44, ff77]
			System.out.println(m.group(0));
			// [a, d, f]
			System.out.println(m.group(1));// 传入组编号1，返回组编号1的字符
			// [1, 4, 7]
			System.out.println(m.group(2));// 传入组编号2，返回组编号2的字符
		}
	}

	private static void splitByNumbers() {
		String s1 = "ab12c3d456ef7gh89i0jkl123mn";
		String[] strs = s1.split("\\d+");
		// [ab, c, d, ef, gh, i, jkl, mn]
		for (String string : strs) {
			System.out.println(string);
		}
	}

	private static void replaceNumbers() {
		String s1 = "ab12c3d456ef7gh89i0jkl123mn";
		String s2 = s1.replaceAll("\\d+", "**");// 匹配所有的阿拉伯数字，替换成**
		System.out.println(s2);// ab**c**d**ef**gh**i**jkl**mn
	}

	private static void replaceWord() {
		String s1 = "Tomorrow I will wear in brown standing in row 10.";
		String s2 = s1.replace("row", "line");// 匹配所有row，包括单词中的部分
		String s3 = s1.replaceAll("\\brow\\b", "line");// 只匹配单词是 row
		System.out.println(s2);// Tomorline I will wear in blinen standing in line 10.
		System.out.println(s3);// Tomorrow I will wear in brown standing in row 10.
	}

	private static void basicMethodUse() {
		String str = "abc123456";
		
		// 1、replace：找到所有abc，用666替换
		System.out.println(str.replace("abc", "666"));
		// 2、replaceAll：找到所有abc（也可传入正则匹配），用666替换
		System.out.println(str.replaceAll("abc", "666"));
		// 3、replaceFirst：找到第一个456（也可传入正则匹配），用999替换
		System.out.println(str.replaceFirst("456", "999"));
		
		// 3、split：传入正则，根据匹配12，将字符串分割成数组返回
		String[] strs = str.split("12");
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	
	
	
}
