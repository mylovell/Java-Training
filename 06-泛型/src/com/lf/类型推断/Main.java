package com.lf.类型推断;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list1 = Collections.emptyList();
		List<Integer> list2 = Collections.emptyList();
		
		System.out.println(list1);
		System.out.println(list2);
	}

}
