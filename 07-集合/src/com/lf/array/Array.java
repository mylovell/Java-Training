package com.lf.array;

public class Array {

	public static void main(String[] args) {
		
		array();
		
		
	}

	private static void array() {
		int[] array = new int[5];
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;
		array[2] = 44;
		for (int i : array) {
			System.out.println(i);
		}
	}

}
