package com.lf.Enum;

//用自定义类 通过常量来做到枚举的效果
//public class Season {
//	
//	private Season() {}
//	public static final Season SPRING = new Season();
//	public static final Season SUMMER = new Season();
//	public static final Season FALL = new Season();
//	public static final Season WINTER = new Season();
//
//}

public enum Season {
	SPRING(5,15), 
	SUMMER(25,35), 
	FALL(15,25), 
	WINTER(-5,5);
	
	
	private int min;
	private int max;
	// 枚举的构造方法不能主动调用，初始化常量的时候会主动调用
	private Season(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
}
