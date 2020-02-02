package com.lf.characterSet;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// 字符集
		
		String str = "MJ码哥";
		
		byte[] bytes = str.getBytes("ASCII");
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(Arrays.toString(str.getBytes()));
		
		System.out.println(Charset.defaultCharset());
		
		
	}

}
