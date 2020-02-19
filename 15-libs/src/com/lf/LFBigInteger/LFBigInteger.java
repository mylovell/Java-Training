package com.lf.LFBigInteger;

import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.lf.LFAssert.LFAssert;
import com.lf.regexTool.RegexTool;

/* 当前数据类型：
 * 
 * 1.(正)超出Long范围
 * 2.(正)Long最大值
 * 3.(正)Long类型
 * 4.(正)Integer最大值
 * 5.(正)Integer类型
 * 6.零
 * 7.(负)Integer类型
 * 8.(负)Integer最小值
 * 9.(负)Long类型
 * 10.(负)Long最小值
 * 11.(负)超出Long范围
 */

public class LFBigInteger {
	
//	private static final BigInteger maxLongBI = new BigInteger(Long.toString(Long.MAX_VALUE));
//	private static final BigInteger minLongBI = new BigInteger(Long.toString(Long.MIN_VALUE));
//	private static final BigInteger maxIntegerBI = new BigInteger(Integer.toString(Integer.MAX_VALUE));
//	private static final BigInteger minIntegerBI = new BigInteger(Integer.toString(Integer.MIN_VALUE));

	private static final BigDecimal maxLongBI = new BigDecimal(Long.MAX_VALUE);
	private static final BigDecimal minLongBI = new BigDecimal(Long.MIN_VALUE);
	private static final BigDecimal maxIntegerBI = new BigDecimal(Integer.MAX_VALUE);
	private static final BigDecimal minIntegerBI = new BigDecimal(Integer.MIN_VALUE);
	private static final BigDecimal ZERO = BigDecimal.ZERO;
	
	public static void main(String[] args) {
		// 超出long二进制位
		System.out.println(numberType("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111_11"));
		// (正)long最大值
		System.out.println(numberType("0b1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111"));
		// (正)Long类型
		System.out.println(numberType("0b11_01000110_11011100_01011101_01100011_10001000_01100101"));
		// (正)Integer最大
		System.out.println(numberType("0b1111111_11111111_11111111_11111111"));
		// (正)Integer类型
		System.out.println(numberType("0b1100100"));
		// 0
		System.out.println(numberType("0b0"));
		// (负)Integer类型
		System.out.println(numberType("0b11111111_11111111_11110010_10000000"));
		// (负)Integer最小值
		System.out.println(numberType("0b10000000000000000000000000000000"));
		// (负)Long类型 -92233720368547758
		System.out.println(numberType("0b11111110_10111000_01010001_11101011_10000101_00011110_10111000_01010010"));
		// (负)Long最小
		System.out.println(numberType("0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000"));

		System.out.println(numberType("92233720368547758078"));
		System.out.println(numberType("9223372036854775807"));
		System.out.println(numberType("92233720368547758"));
		System.out.println(numberType("2147483647"));
		System.out.println(numberType("21474836"));
		System.out.println(numberType("0"));
		System.out.println(numberType("-21474836"));
		System.out.println(numberType("-2147483648"));
		System.out.println(numberType("-92233720368547758"));
		System.out.println(numberType("-9223372036854775808"));
		System.out.println(numberType("-92233720368547758078"));
		
		System.out.println(numberType("92233720368547758078"));
		System.out.println(numberType("0x7fffffffffffffff"));
		System.out.println(numberType("0x7ffffffffffffff"));
		System.out.println(numberType("0x7fffffff"));
		System.out.println(numberType("21474836"));
		System.out.println(numberType("0"));
		System.out.println(numberType("-21474836"));
		System.out.println(numberType("0x80000000"));
		System.out.println(numberType("0x8000000000000011"));
		System.out.println(numberType("0x8000000000000000"));
		System.out.println(numberType("-92233720368547758078"));
		
		
		
//		LFAsserts.test(decimalToBinary("1").contentEquals("1111111111111111111111111111111111111111111111111111111111111110"));
//		LFAsserts.test(decimalToBinary("-2").contentEquals("1111111111111111111111111111111111111111111111111111111111111110"));
//		
//		
//		LFAsserts.test(decimalToHex("1").equals("1"));
//		
//		LFAsserts.test(binaryToDecimal("1").equals("1"));
//		LFAsserts.test(binaryToDecimal("1").equals("1"));
		
	}
	
	static String numberType(String content) {

		if (content == null || content.equals("")) {
			return "提示：请输入值";
		}
		
		if (content.contains(".")) {
			return "提示：暂不支持浮点数";
		}
		
		// 输入二进制
		if (content.matches("0b[01_]+[Ll]?")) {
			
			content = content.replaceAll("(0b)?[_lL]?", "");
			
			// 转成bi，注意负数
			BigDecimal bi = null;
			if (content.length() <= 32) {
				Integer intV = new BigInteger(content, 2).intValue();//可区分正负
				bi = new BigDecimal(intV);
			} else if (content.length() > 32 && content.length() <= 64) {
				Long longV = new BigInteger(content, 2).longValue();//可区分正负
				bi = new BigDecimal(longV);
			} else {
				// 64位是long负数
				// 63位是long正数
				if (content.length() > 64) {
					return content.length() + "位二进制，超出Long类型取值范围";
				}
			}
			
			String s = null;
			if (bi.compareTo(minLongBI) < 0) {
				s = "小于Long类型最小值";// 用不到
			} else if (bi.compareTo(minLongBI) == 0) {
				s = "(负)Long类型最小值";
			} else if (bi.compareTo(minLongBI) > 0 && bi.compareTo(minIntegerBI) < 0) {
				s = "(负)Long类型";
			} else if (bi.compareTo(minIntegerBI) == 0) {
				s = "(负)Integer类型最小值";
			}  else if (bi.compareTo(minIntegerBI) > 0 && bi.compareTo(ZERO) < 0) {
				s = "(负)Integer类型";
			} else if (bi.compareTo(ZERO) == 0) {
				s = "零";
			} else if (bi.compareTo(maxIntegerBI) < 0 && bi.compareTo(ZERO) > 0) {
				s = "(正)Integer类型";
			} else if (bi.compareTo(maxIntegerBI) == 0) {
				s = "(正)Integer最小值";
			} else if (bi.compareTo(maxLongBI) < 0 && bi.compareTo(maxIntegerBI) > 0){
				s = "(正)Long类型";
			} else if (bi.compareTo(maxLongBI) == 0) {
				s = "(正)Long最大值";
			} else if (bi.compareTo(maxLongBI) > 0) {
				s = "超过Long最大值";// 用不到
			} 
			return "提示：二进制，" + s + ((Long)bi.longValue()).toString();
		}
		
		if (content.matches("[+-]?[0-9_]+[Ll]?")) {
			
			content = content.replaceAll("[+_Ll]", "");
			BigDecimal bd = new BigDecimal(content);
			
			String s = null;
			if (bd.compareTo(minLongBI) < 0) {
				s = "(负)小于Long最小值";
			} else if (bd.compareTo(minLongBI) == 0) {
				s = "(负)Long最小值";
			} else if (bd.compareTo(minLongBI) > 0 && bd.compareTo(minIntegerBI) < 0) {
				s = "(负)Long类型";
			} else if (bd.compareTo(minIntegerBI) == 0) {
				s = "(负)Integer最小值";
			} else if (bd.compareTo(minIntegerBI) > 0 && bd.compareTo(ZERO) < 0) {
				s = "(负)Integer类型";
			} else if (bd.compareTo(ZERO) == 0) {
				s = "零";
			} else if (bd.compareTo(maxIntegerBI) < 0 && bd.compareTo(ZERO) > 0) {
				s = "(正)Integer类型";
			} else if (bd.compareTo(maxIntegerBI) == 0) {
				s = "(正)Integer最大值";
			} else if (bd.compareTo(maxIntegerBI) > 0 && bd.compareTo(maxLongBI) < 0) {
				s = "(正)Long类型";
			} else if (bd.compareTo(maxLongBI) == 0) {
				s = "(正)Long最大值";
			} else if (bd.compareTo(maxLongBI) > 0) {
				s = "(正)大于Long最大值";
			}
			
			return "提示：十进制" + s;
		}
		
		if (content.matches("0x[0-9a-f]+")) {
			
			content = content.replaceAll("(0x)?[_Ll]?", "");
			BigInteger bi = new BigInteger(content, 16);
			BigDecimal bd = new BigDecimal(bi);
			
			String s = null;
			if (bd.compareTo(minLongBI) < 0) {
				s = "(负)小于Long最小值";
			} else if (bd.compareTo(minLongBI) == 0) {
				s = "(负)Long最小值";
			} else if (bd.compareTo(minLongBI) > 0 && bd.compareTo(minIntegerBI) < 0) {
				s = "(负)Long类型";
			} else if (bd.compareTo(minIntegerBI) == 0) {
				s = "(负)Integer最小值";
			} else if (bd.compareTo(minIntegerBI) > 0 && bd.compareTo(ZERO) < 0) {
				s = "(负)Integer类型";
			} else if (bd.compareTo(ZERO) == 0) {
				s = "零";
			} else if (bd.compareTo(maxIntegerBI) < 0 && bd.compareTo(ZERO) > 0) {
				s = "(正)Integer类型";
			} else if (bd.compareTo(maxIntegerBI) == 0) {
				s = "(正)Integer最大值";
			} else if (bd.compareTo(maxIntegerBI) > 0 && bd.compareTo(maxLongBI) < 0) {
				s = "(正)Long类型";
			} else if (bd.compareTo(maxLongBI) == 0) {
				s = "(正)Long最大值";
			} else if (bd.compareTo(maxLongBI) > 0) {
				s = "(正)大于Long最大值";
			}
			
			return "提示：16进制" + s;
		}
		
		return "无法识别该数";
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
		
//		StringBuilder sb = new StringBuilder();
//		Long a = Long.valueOf(value, 10);
//		for (int i = 0; i < 64; i++) {
//			Long t = (a & 0x8000000000000000L >>> i) >>> (63 - i);
//			//System.out.print(t);
//			sb.append(t);
//			//if ((i+1) % 8 == 0 && (i != 63)) System.out.print("_");
//			if ((i+1) % 8 == 0 && (i != 63)) sb.append("_");
//		}
//		return sb.toString();
		
		// 简便方法
		Long long1 = Long.valueOf(value);
//		String string = Long.toString(long1, 2);// 无法处理负整数
		String string = Long.toBinaryString(long1);
		
		return string;
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
