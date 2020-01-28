package com.lf.sort;

public class Person implements Comparable<Person> {
	private int age;
	public Person(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (o == null) return 1;
		return age - o.age;
	};
	
	@Override
	public String toString() {
		return "Person="+age;
	}

}
