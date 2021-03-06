package com.lf.Date;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Date date1 = new Date();
		System.out.println("当前日期：" + date1);
		
		// 1970年开始
		Date date2 = new Date(0);
		System.out.println(date2);
		
		// 2000毫秒 + 1970-01-01 00:00:00 (GMT)
		// 2000毫秒 + 1970-01-01 08:00:00 (CST)
		Date date3 = new Date(5000);
		System.out.println(date3);

		date3.setTime(3000);
		System.out.println(date3);
		
		System.out.println(date3.getTime());
		
	}

}
