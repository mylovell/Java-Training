package com.lf.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
//		ArrayList();
//		retainAll();
//		toArray();
		
		
		
	}

	private static void toArray() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		
		Object[] array1 = list.toArray();
		// [Ljava.lang.Object;@27c170f0
		System.out.println(array1);
		// [11, 22, 33]
		System.out.println(Arrays.toString(array1));
 		
		
		Integer[] array2 = list.toArray(new Integer[0]);
		// [Ljava.lang.Integer;@27c170f0
		System.out.println(array2);
		// [11, 22, 33]
		System.out.println(Arrays.toString(array2));
	}

	private static void retainAll() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(11);
		list1.add(22);
		list1.add(33);
		list1.add(44);
		list1.add(55);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(22);
		list2.add(44);
		
		list1.retainAll(list2);
		// [22, 44]
		System.out.println(list1);
	}

	private static void ArrayList() {
		ArrayList list = new ArrayList();
		list.add(11);
		list.add(false);
		list.add(null);
		list.add(3.14);
		list.add(0, "Jack");
		list.add('8');
		
		// 3
		System.out.println(list.indexOf(null));
		// 6
		System.out.println(list.size());
		// [Jack, 11, false, null, 3.14, 8]
		System.out.println(list);
	}

}
