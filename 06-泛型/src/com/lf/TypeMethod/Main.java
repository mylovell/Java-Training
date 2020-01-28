package com.lf.TypeMethod;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		List<Box<Integer>> boxes = new ArrayList<>();
		addBox(11, boxes);
		addBox(12, boxes);
		addBox(13, boxes);
		
		System.out.println(boxes);
	}
	
	static <T> void addBox(T element, List<Box<T>> boxes) {
		Box<T> box = new Box<>(element);
		boxes.add(box);
	}

}
