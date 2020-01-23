package com.lf;

public class Main {
	
	public static void main(String[] args) {
		
		// 写法1
//		execute(20, v1 -> v1*3);
		
		// 写法2
//		execute(20, v1 -> {
//			return v1*3;
//		});
		
		// 写法3
		execute(20, (int v1) -> {
			return v1*3;
		});
		
		
	}
	
	static void execute(int v1, Calculator c) {
		System.out.println(c.calculate(v1));
	}

}
