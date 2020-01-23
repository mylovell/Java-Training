package com.lf.Predicate;

import java.util.function.Predicate;

public class Person {
	
	public static void main(String[] args) {
		
		int[] nums = {11, 33, 44, 88, 77, 66};
		Person person = new Person();
		String string = person.join(nums, (n) -> (n&1) == 0);
		
		// 44_88_66
		System.out.println(string);
	}
	

	String join(int[] nums, Predicate<Integer> p) {
		
		if(nums == null || p == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int n : nums) {
			if (p.test(n)) {// true : 是偶数
				sb.append(n).append("_");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	

}
