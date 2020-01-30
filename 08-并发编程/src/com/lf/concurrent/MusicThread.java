package com.lf.concurrent;

public class MusicThread extends Thread {
	
	public void run() {
		System.out.println("开启了新线程：" + Thread.currentThread());
	}

}
