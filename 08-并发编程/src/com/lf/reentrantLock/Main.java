package com.lf.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		
//		synchronizedMethod();
//		lock();
		
		/*
		 一个线程如果正在执行代码（任务），就会消耗CPU时间片
		 
		 BLOCKED状态：等待锁
		 while (锁没有被释放); // 会消耗CPU时间片（一直在执行while循环）
		 
		 WAITTING状态：等待其他线程 // 不消耗CPU时间片，真的睡着了
		 
		 */
		
		
	}

	private static void lock() {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		System.out.println(456);
		lock.unlock();
		lock.unlock();
	}

	private static void synchronizedMethod() {
		synchronized ("1") {
			synchronized ("1") {
				System.out.println("123");
			}
		}
	}

}

