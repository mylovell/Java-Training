package com.lf.DecimalFormat;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		// 123456.789
		customFormat("#.####", 123456.789);
				
		// 123456.79 ，最后那位数字四舍五入了
		customFormat("#.##", 123456.789);
		
		// 12,345,678.789 ，用了,分组分隔符
		customFormat("###,###.####", 12345678.789);
		
		// 0123456.7890 ，不足的用0补齐
		customFormat("0000000.0000", 123456.789);
		
	}
	
	static void customFormat(String pattern, double value) {
		DecimalFormat fmt = new DecimalFormat(pattern);
		System.out.println(fmt.format(value));
	}

}
 