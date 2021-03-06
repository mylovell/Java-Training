package com.lf.Function;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		String[] strs = {"12", "567", "666"};
//		int result = main.sum(strs, Integer::valueOf);
		int result = main.sum(strs, Integer::valueOf, (n) -> n % 10);
		System.out.println(result);
		
	}
	
	// 定义一个方法：数组中的每个字符串转成数字，并累加
	int sum(String[] strs, Function<String, Integer> f) {
		if (strs == null || f == null) return 0;
		int result = 0;
		for (String str : strs) {
			result += f.apply(str);
		}
		return result;
	}
	
	// 把所有个位数都加起来
	int sum(String[] strs, 
			Function<String, Integer> f1, 
			Function<Integer, Integer> f2) {
		if (strs == null || f1 == null || f2 == null) return 0;
		int result = 0;
		for (String str : strs) {
//			result += f1.andThen(f2).apply(str);
			result += f2.compose(f1).apply(str);
		}
		return result;
	}

}
