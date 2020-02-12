package com.lf.wildcards;

public class Main {

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		Box<Double> box2 = new Box<>();
		Box<Object> box3 = new Box<>();

		Box<? extends Number> box4 = null;
		box4 = box1;
		box4 = box2;
//		box4 = box3;
		
		showBox(box1);
		showBox(box2);
//		showBox(box3);
		showBox(box4);
		
	}
	
	static void showBox(Box<? extends Number> box) {
		
	}
	
//	static <T extends Number> void showBox(Box<T> box) {
//		
//	}

}
