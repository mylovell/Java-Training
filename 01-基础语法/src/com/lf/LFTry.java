package com.lf;

public class LFTry {

	public static void main(String[] args) {
		
		// 检查型异常(需要处理万一执行失败的情况)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 检查型异常
		try {
			Class cls = Class.forName("Dog");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// 非检查型异常( RuntimeException )
		int[] array = {11,22,33};
		array[4] = 44;
		
		// 非检查型异常( Error )
		for (int i = 0; i < 200; i++) {
			long[] a = new long[1000000000];
		}
	}

}
