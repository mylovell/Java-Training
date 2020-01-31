package com.lf.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Station implements Runnable {
	private int tickets = 100;
	private ReentrantLock lock = new ReentrantLock();
	
	public boolean saleTicket() {
		try {
			lock.lock();
			if (tickets < 1) return false;
			tickets-- ;
			String name = Thread.currentThread().getName();
			System.out.println(name + "卖了1张，剩" + tickets + "张");
			return tickets > 0;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		while (saleTicket()) {
		}
	}
	

}
