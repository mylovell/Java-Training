package com.lf.TypeMethod;

public class Box<E> {
	private E element;
	public Box() {};
	public Box(E element) {
		this.element = element;
	}
	
	// 静态方法使用泛型，必须变成泛型方法
	public static <E> void println(E element) {
		
	}
	
	@Override
	public String toString() {
		return "Box=" + element;
	}
	
}
