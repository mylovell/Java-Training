package com.lf.concurrent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
//		sleep();
		customThread();
		
		
	}

	private static void customThread() {
		MusicThread thread = new MusicThread();
		thread.start();//建议调用，Thread[Thread-0,5,main]
//		thread.run();//在当前线程调用，Thread[main,5,main]
		
	}

	private static void sleep() throws InterruptedException {
		Thread thread = new Thread(() ->  {
			System.out.println("begin");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
		});
		
		thread.start();
		Thread.sleep(1000);
//		thread.interrupt();
	}

}
