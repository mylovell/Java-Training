package com.lf.communication;

public class Drop {
	private String food;
	private boolean empty = true;
	
	public synchronized String get() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		empty = true;
		notifyAll();
		return food;
	}
	
	public synchronized void add(String food) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		empty = false;
		this.food = food;
		notifyAll();
	}
	
}
