package com.lf.通配符下界;

public class Main {

	public static void main(String[] args) {
		
		Box<Integer> p1 = null;
		Box<Number> p2 = null;
		Box<? super Integer> p3 = null;
		Box<? super Number> p4 = null;

		testLower(p1);
		testLower(p2);
		testLower(p3);
		testLower(p4);
	}
	
	static void testLower(Box<? super Integer> box) {
		System.out.println(box);
	}

}

class Box<T> {
	public Box() {}
}
