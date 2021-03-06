package com.lf.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		
//		calendar();
		
		simpleDateFormat();
		
	}



	private static void calendar() {
		Calendar c = Calendar.getInstance();
		printCalendar(c);
		
		c.set(2020, 05, 06);
		printCalendar(c);
		
		c.add(Calendar.MONTH, 2);
		printCalendar(c);
	}
	
	
	
	private static void printCalendar(Calendar c) {
		
		System.out.println(
				c.get(Calendar.YEAR) + "-"
				+ 
				c.get(Calendar.MONTH) + "-"
				+
				c.get(Calendar.DAY_OF_MONTH)
				);	
	}
	
	private static void simpleDateFormat() throws ParseException {
		System.out.println("------------");
		
		SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String str = fmt.format(new Date());
		System.out.println("Date转String："+str);
		
		
		Date date = fmt.parse(str);
		System.out.println("String转Date："+date);
	}

}
