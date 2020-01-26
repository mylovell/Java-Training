package com.lf.genericType;

public class StudentA<N, S> {
	private N no;
	private S score;
	public N getNo() {
		return no;
	}
	public S getScore() {
		return score;
	}
	
	public StudentA(N no, S score) {
		this.no = no;
		this.score = score;
	}
	
	
}
