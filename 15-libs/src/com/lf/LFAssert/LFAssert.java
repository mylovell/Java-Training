package com.lf.LFAssert;

public class LFAssert {

	public static void test(boolean v) {
		if (v) return;
		System.err.println(new RuntimeException().getStackTrace()[1]);
//		try {
//			throw new IllegalArgumentException("条件不成立");
//		} catch (Exception e) {
//			System.err.println(e.getStackTrace()[1]);
//		}
	}
	

}
