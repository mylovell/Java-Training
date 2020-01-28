package com.lf.comparable;

public class Student<T extends Comparable<T>> implements Comparable<Student<T>> {
	
	private T score;
	public T getScore() {
		return score;
	}


	public void setScore(T score) {
		this.score = score;
	}


	public Student(T score) {
		super();
		this.score = score;
	}
	

	@Override
	public int compareTo(Student<T> o) {
		if (o == null) return 1;
		if (score != null) return score.compareTo(o.score);
		return o.score == null ? 0 : -1;
	}


	@Override
	public String toString() {
		return "Student [score=" + score + "]";
	}
	
	

}
