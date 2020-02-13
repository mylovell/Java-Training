package com.lf.join;

public class Main {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			System.out.println("t1 - begin");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1 - end");
		});
		t1.start();
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 - begin");
			System.out.println("t1.isAlive - " + t1.isAlive());
			try {
				t1.join();
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			System.out.println("t1.isAlive - " + t1.isAlive());
			System.out.println("t2 - end");
		});
		t2.start();

	}

}
