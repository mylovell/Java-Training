package com.lf.LFBigInteger;

import java.math.BigInteger;

import com.lf.LFAsserts.LFAsserts;


public class LFBigInteger {

	public static void main(String[] args) {
		
		LFAsserts.test(binaryToDecimal("1").equals("1"));
		LFAsserts.test(binaryToDecimal("1").equals("1"));
		
	}
	

	private static String binaryToDecimal(String value) {
		if (value.startsWith("0b")) {value = value.substring(2);}
		if (value.matches("\\w+\\B[lL]\\b")) {value = value.substring(0, value.length()-1);}
		
		Long long1 = new BigInteger(value, 2).longValue();
		return long1.toString();
	}
	
	private static String binaryToHex(String value) {
		if (value.startsWith("0b")) {value = value.substring(2);}
		if (value.matches("\\w+\\B[lL]\\b")) {value = value.substring(0, value.length()-1);}
		
		Long longValue = new BigInteger(value, 2).longValue();
		String longString = Long.toHexString(longValue);
		return longString;
	}
	
	/**
	 * 十进制 --> 二进制
	 * @param value 正负整数的字符串
	 * @return
	 */
	private static String decimalToBinary(String value) {
		
		StringBuilder sb = new StringBuilder();
		Long a = Long.valueOf(value, 10);
		for (int i = 0; i < 64; i++) {
			Long t = (a & 0x8000000000000000L >>> i) >>> (63 - i);
			//System.out.print(t);
			sb.append(t);
			//if ((i+1) % 8 == 0 && (i != 63)) System.out.print("_");
			if ((i+1) % 8 == 0 && (i != 63)) sb.append("_");
		}
		return sb.toString();
		
		// 简便方法
//		Long long1 = Long.valueOf(value);
////		String string = Long.toString(long1, 2);// 无法处理负整数
//		String string = Long.toBinaryString(long1);
//		return string;
	}
	
	private static String decimalToHex(String value) {
		Long long1 = Long.valueOf(value);
		String string = Long.toOctalString(long1);
		return string;
	}
	
	private static Long hexToDecimal(String value) {
		
		if (value.startsWith("0x")) {value = value.substring(2, value.length());}
		if (value.matches("\\w+[lL]")) {value = value.substring(0, value.length()-1);}
//		Long long1 = Long.valueOf(value, 16); // 无法处理负数十六进制
//		long long1 = Long.parseLong(value, 16); // 无法处理负数十六进制
		Long long1 = (Long)(new BigInteger(value, 16).longValue());//先转为Long，再转string，才先显示对的字符串
		return long1;
	}

	private static String hexToBinary(String value) {
		Long long1 = hexToDecimal(value);
//		String string = Long.toString(long1, 2);//只对正数有用
		String string = Long.toBinaryString(long1);
		return string;
	}
	
	

}
