package com.lf.Enum;

public class Main {

	public static void main(String[] args) {
		
//		Season season = Season.SPRING;
//		System.out.println(season);
//		test(season);
		
		Season season = Season.SPRING;
		test(season);
		test1(season);
		
		
		
	}
	
	public static void test(Season season) {
		if (season == Season.SPRING) {
			System.out.println("春天~~~自定义类和系统枚举类都能执行这个");
			System.out.println(season.getMin());
		}
	}
	
	public static void test1(Season season) {
		switch (season) {
		case SPRING:
			System.out.println("春天");
			break;

		default:
			System.out.println("非春天");
			break;
		}
	}

}
