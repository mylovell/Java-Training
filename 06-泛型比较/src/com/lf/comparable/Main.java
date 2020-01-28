package com.lf.comparable;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Student[] ss = {
				new Student<>(11),
				new Student<>(88),
				new Student<>(55)
		};
		System.out.println(getMax(ss));
	}
	
	static <T extends Comparable<T>> T getMax(T[] array) {
		if (array == null || array.length == 0) return null;
		T max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) continue;
			if (array[i].compareTo(max) <= 0) continue;
			max = array[i];
		}
		return max;
	}

}
