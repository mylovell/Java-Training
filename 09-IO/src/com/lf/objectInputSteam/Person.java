package com.lf.objectInputSteam;

import java.io.Serializable;

public class Person implements Serializable {

	public int age ;
	public int weight ;
	public int score ;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	

	public Person(int age, int weight, int score) {
		super();
		this.age = age;
		this.weight = weight;
		this.score = score;
	}

	public Person() {
		
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", weight=" + weight + ", score=" + score + "]";
	}
	
	
}
