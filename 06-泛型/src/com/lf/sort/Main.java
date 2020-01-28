package com.lf.sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		compare();
	}

	private static void compare() {
		Person[] ps1 = {
				new Person(11),
				new Person(88),
				new Person(55),
		};
		Arrays.sort(ps1);
		System.out.println(Arrays.toString(ps1));
		
		
		Person[] ps2 = {
				new Person(11),
				new Person(88),
				new Person(55),
		};
//		Arrays.sort(ps2, new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o2.getAge() - o1.getAge();
//			}
//		});
		Arrays.sort(ps2, (o1,o2)->o2.getAge()-o1.getAge());
		System.out.println(Arrays.toString(ps2));
	}

}
