package com.lf.consumer;

import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		Integer[] nums = { 11, 22, 33 };
		forEach(nums, (num) -> {
			System.out.println(num+100);
		});
		
		
	}
	
	// 遍历每一个数，并执行传入的逻辑代码块
	static <T> void forEach(T[] array, Consumer<T> consumer) {
		if (array == null || consumer == null) return;
		for (T ele : array) {
			consumer.accept(ele);
		}
	}

}
