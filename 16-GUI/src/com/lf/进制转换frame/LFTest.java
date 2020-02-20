package com.lf.进制转换frame;

import static com.lf.LFAssert.LFAssert.*;
import static com.lf.进制转换frame.DigitChangeFrame.*;


public class LFTest {

	public static void main(String[] args) {
		
		test_hexConvert();
		
	}

	/**
	 * 测试进制转换函数
	 */
	private static void test_hexConvert() {
		// 二进制 --> 十进制：
		
		// (正)超Long
		test(hexConvert("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111_11", 10) == null);
		// (正)Long 最大值，有下划线
		test(hexConvert("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111", 10).equals(Long.toString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("0b11_01000110_11011100_01011101_01100011_10001000_01100101l", 10).equals("922337203685477"));
		// (正)Integer 最大值，有L
		test(hexConvert("0b1111111_11111111_11111111_11111111L", 10).equals(Integer.toString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("0b1100100", 10).equals("100"));
		// 零
		test(hexConvert("0b0", 10).equals("0"));
		// (负)Integer 类型
		test(hexConvert("0b11111111_11111111_11110010_10000000", 10).equals("-3456"));
		// (负)Integer 最小值
		test(hexConvert("0b10000000000000000000000000000000", 10).equals(Integer.toString(Integer.MIN_VALUE)));
		// (负)Long 类型
		test(hexConvert("0b11111110_10111000_01010001_11101011_10000101_00011110_10111000_01010010", 10).equals("-92233720368547758"));
		// (负)Long 最小值
		test(hexConvert("0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000", 10).equals(Long.toString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000_00", 10) == null);
		// 含有01blL之外的字母
		test(hexConvert("0b11111110_10111000_01010001_11101abc", 10) == null);
		
		
		
		// 二进制 --> 十六进制：
		
		// (正)超Long
		test(hexConvert("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111_11", 16) == null);
		// (正)Long 最大值，有下划线
		test(hexConvert("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111", 16).equals(Long.toHexString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("0b11_01000110_11011100_01011101_01100011_10001000_01100101l", 16).equals("346dc5d638865"));
		// (正)Integer 最大值，有L
		test(hexConvert("0b1111111_11111111_11111111_11111111L", 16).equals(Integer.toHexString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("0b1100100", 16).equals("64"));
		// 零
		test(hexConvert("0b0", 16).equals("0"));
		// (负)Integer 类型
		test(hexConvert("0b11111111_11111111_11110010_10000000", 16).equals("fffff280"));
		// (负)Integer 最小值
		test(hexConvert("0b10000000000000000000000000000000", 16).equals(Integer.toHexString(Integer.MIN_VALUE)));
		// (负)Long类型
		test(hexConvert("0b11111110_10111000_01010001_11101011_10000101_00011110_10111000_01010010", 16).equals("feb851eb851eb852"));
		// (负)Long 最小值
		test(hexConvert("0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000", 16).equals(Long.toHexString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000_00", 16) == null);
		// 含有01blL之外的字母
		test(hexConvert("0b11111110_10111000_01010001_11101abc", 16) == null);
		
		
		
		// 十六进制 --> 二进制：
		
		// (正)超Long
		test(hexConvert("0x7fffffffffffffffff", 2) == null );
		// (正)Long 最大值，有下划线
		test(hexConvert("0x7fffffffffffffff", 2).equals(Long.toBinaryString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("0x346dc5d638865", 2).equals("11010001101101110001011101011000111000100001100101"));
		// (正)Integer 最大值，有L
		test(hexConvert("0x7fffffff", 2).equals(Integer.toBinaryString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("0x64", 2).equals("1100100"));
		// 零
		test(hexConvert("0x0", 2).equals("0"));
		// (负)Integer 类型
		test(hexConvert("0xfffff280", 2).equals("11111111111111111111001010000000"));
		// (负)Integer 最小值
		test(hexConvert("0x80000000", 2).equals(Integer.toBinaryString(Integer.MIN_VALUE)));
		// (负)Long类型
		test(hexConvert("0xfeb851eb_851eb852l", 2).equals("1111111010111000010100011110101110000101000111101011100001010010"));
		// (负)Long 最小值
		test(hexConvert("0x8000000000000000L", 2).equals(Long.toBinaryString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("0x8000000000000000000L", 2) == null);
		// 含有之外的字母
		test(hexConvert("0x80000000000000xyL", 2) == null);
		
		
		
		
		// 十六进制 --> 十进制：
		
		// (正)超Long
		test(hexConvert("0x7fffffffffffffffff", 10) == null );
		// (正)Long 最大值，有下划线
		test(hexConvert("0x7fffffffffffffff", 10).equals(Long.toString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("0x346dc5d638865", 10).equals("922337203685477"));
		// (正)Integer 最大值，有L
		test(hexConvert("0x7fffffff", 10).equals(Integer.toString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("0x64", 10).equals("100"));
		// 零
		test(hexConvert("0x0", 10).equals("0"));
		// (负)Integer 类型
		test(hexConvert("0xfffff280", 10).equals("-3456"));
		// (负)Integer 最小值
		test(hexConvert("0x80000000", 10).equals(Integer.toString(Integer.MIN_VALUE)));
		// (负)Long类型
		test(hexConvert("0xfeb851eb_851eb852l", 10).equals("-92233720368547758"));
		// (负)Long 最小值
		test(hexConvert("0x8000000000000000L", 10).equals(Long.toString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("0x8000000000000000000L", 10) == null);
		// 含有之外的字母
		test(hexConvert("0x80000000000000xyL", 10) == null);
		
		
		
		// 十进制 --> 十六进制：

		// (正)超Long
		test(hexConvert("9223372036854775807777", 16) == null);
		// (正)Long 最大值，有下划线
		test(hexConvert("9223372036854775807", 16).equals(Long.toHexString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("922337203685477", 16).equals("346dc5d638865"));
		// (正)Integer 最大值，有L
		test(hexConvert("2147483647", 16).equals(Integer.toHexString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("100", 16).equals("64"));
		// 零
		test(hexConvert("0", 16).equals("0"));
		// (负)Integer 类型
		test(hexConvert("-3456", 16).equals("fffff280"));
		// (负)Integer 最小值
		test(hexConvert("-2147483648", 16).equals(Integer.toHexString(Integer.MIN_VALUE)));
		// (负)Long类型
		test(hexConvert("-92233720368547758", 16).equals("feb851eb851eb852"));
		// (负)Long 最小值
		test(hexConvert("-9223372036854775808", 16).equals(Long.toHexString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("-9223372036854775808888", 16) == null);
		// 含有01blL之外的字母
		test(hexConvert("-92233720368547abc0x0b", 16) == null);
		
		
		
		
		// 十进制 --> 二进制：
		// (正)超Long
		test(hexConvert("9223372036854775807777", 2) == null );
		// (正)Long 最大值，有下划线
		test(hexConvert("9223372036854775807", 2).equals(Long.toBinaryString(Long.MAX_VALUE)));
		// (正)Long类型，有l
		test(hexConvert("922337203685477", 2).equals("11010001101101110001011101011000111000100001100101"));
		// (正)Integer 最大值，有L
		test(hexConvert("2147483647", 2).equals(Integer.toBinaryString(Integer.MAX_VALUE)));
		// (正)Integer 类型
		test(hexConvert("100", 2).equals("1100100"));
		// 零
		test(hexConvert("0", 2).equals("0"));
		// (负)Integer 类型
		test(hexConvert("-3456", 2).equals("11111111111111111111001010000000"));
		// (负)Integer 最小值
		test(hexConvert("-2147483648", 2).equals(Integer.toBinaryString(Integer.MIN_VALUE)));
		// (负)Long类型
		test(hexConvert("0xfeb851eb_851eb852l", 2).equals("1111111010111000010100011110101110000101000111101011100001010010"));
		// (负)Long 最小值
		test(hexConvert("-9223372036854775808", 2).equals(Long.toBinaryString(Long.MIN_VALUE)));
		// (负)超Long
		test(hexConvert("-9223372036854775808888", 2) == null);
		// 含有之外的字母
		test(hexConvert("-92233720368547abc0x0b", 2) == null);
	}
	
	
}
