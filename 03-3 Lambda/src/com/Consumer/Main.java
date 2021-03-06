package com.Consumer;

import java.util.function.Consumer;

public class Main {
	
	public static void main(String[] args) {
		
		Main main = new Main();
//		main.run();
		main.run2();
	}
	
	public void run() {
		int[] nums = {11, 33, 44, 88, 77, 66};
		
		// 调用方法forEach，传入实现了accept的代码块做为参数
		forEach(nums, (n) -> {
			String result = ((n & 1) == 0) ? "偶数" : "奇数";
			System.out.println(n + "是" + result);
		});
		
	}
	
	// forEach 方法的实现
	void forEach(int[] nums, Consumer<Integer> c) {
		if (nums == null || c == null) return;
		for (int n : nums) {
			c.accept(n);
		}
	}
	
	
	public void run2() {
		int[] nums = {11, 33, 44, 88, 77, 66};
		
		// 调用方法forEach，传入参数
		forEach(nums, (n) -> {
			String result = ((n & 1) == 0) ? "偶数" : "奇数";
			System.out.println(n + "是" + result);
		}, (n) -> {
			String result = ((n % 3) == 0) ? "能" : "不能";
			System.out.println(n + result + "被3整除");
		});
		
	}
	
	// forEach 方法的实现
	void forEach(int[] nums, Consumer<Integer> c1, Consumer<Integer> c2) {
		if (nums == null || c1 == null || c2 == null) return;
		for (int n : nums) {
			c1.andThen(c2).accept(n);// 调用顺序有点不太懂
		}
	}
	
}
