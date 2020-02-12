package com.lf.通配符上界;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> is = Arrays.asList(1,2,3);
		System.out.println(sum(is));

	}
	
	static double sum(List<? extends Number> list) {
		double s = 0.0;
		for (Number number : list) {
			s += number.doubleValue();
		}
		return s;
	}

}
