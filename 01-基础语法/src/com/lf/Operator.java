package com.lf;

public class Operator {

	public static void main(String[] args) {
		
		operator();

	}
	
	private static void operator() {
		
		// 后缀：先赋值，后运算
//		int a = 1;
//		int b = a++;
//		// a = 2, b = 1
//		System.out.println("a = " + a + "," + " b = " +  b);
		
		// 一元（单目）
//		int a = 1;
//		int b = ++a;
//		// a = 2, b = 2
//		System.out.println("a = " + a + "," + " b = " +  b);
		
		
		// 乘除模
//		int a2 = 8;
//		int b2 = a2 % 5;
//		// a2 = 8, b2 = 3
//		System.out.println("a2 = " + a2 + "," + " b2 = " +  b2);

//		// >>
//		int a = 128;
//		int b = a>>2;
//		// a = -4, b = -2
//		System.out.println("a = " + a + "," + " b = " +  b);

		// >>>
//		int a = -1;
//		int b = a>>>1;
//		// a = -1, b = 2147483647(即 int 的最大取值范围)
//		System.out.println("a = " + a + "," + " b = " +  b);
	
		// 二进制打印成整数
//		int a = 0b00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000010;
//		int a = 0b11111111_11111111_11111111_11111101;
//		System.out.println("a = " + a);	
		
		
		// 整数 --> 二进制
		
		// 4字节int类型整数，打印成二进制
		// -3：11111111_11111111_11111111_11111101
		// 3：00000000_00000000_00000000_00000011
		// 2147483647：01111111_11111111_11111111_11111111
		// -2147483648：10000000_00000000_00000000_00000000
//		int a = -5;
//		System.out.print(a + "：0b");
//		for (int i = 0; i < 32; i++) {
//			int t = (a & 0x80000000 >>> i) >>> (31 - i);// 0x8000_0000
//			System.out.print(t);
//			if ((i+1) % 8 == 0 && (i != 31)) System.out.print("_");
//		}
//		System.out.println("Integer类型最小数（10进制）：" + Integer.MIN_VALUE);
//		System.out.println("Integer类型最大数（10进制）：" + Integer.MAX_VALUE);
//		System.out.println(0x80000000);
//		System.out.println(0x8000000000000000L);
		
		
		// 8字节long类型整数，打印成二进制
		// 9223372036854775807：0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111
		// -9223372036854775808：0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000
//		long a = -9223372036854775808L;
//		System.out.print(a + "：0b");
//		for (long i = 0; i < 64; i++) {
//			long t = (a & 0x8000000000000000L >>> i) >>> (63 - i);// 0x8000_0000
//			System.out.print(t);
//			if ((i+1) % 8 == 0 && (i != 63)) System.out.print("_");;
//		}
		// 9223372036854775807 , 
		// -9223372036854775808
//		System.out.println("Long类型最小数（10进制）：" + Long.MIN_VALUE);
//		System.out.println("Long类型最大数（10进制）：" + Long.MAX_VALUE);
		
		
		// 10进制打印成16进制
//		System.out.println("0x" + Integer.toHexString(2020));// 0x7e4
//		System.out.println("0x" + Long.toHexString(2020L));// 0x7e4
//		System.out.println("0x" + Integer.toHexString(-1));// 0xffffffff
		
		
		// 按位或
//		int a = 0b0111;
//		int b = 0b0011;
//		int c = a|b;
//		System.out.println("a = " + a + "," + " b = " +  b + "," + " c = " +  c);
		
		// 二进制、16进制转10进制(默认四个字节，1字节或2字节需要在前面标识清楚)
//		System.out.println(0b1111);// 15
//		System.out.println(0b11111101);// 253
//		System.out.println((byte)0b11111101);// -3(一个字节)
//		System.out.println((short)0b11111111_11111101);// -3(两个字节)
//		System.out.println(0b11111111_11111111_11111111_11111101);// -3(默认四个字节)
//		System.out.println(0x80000000);// -2147483648
//		System.out.println(0x8000000000000000L);// -9223372036854775808
		
		
//		boolean a = true;
//		boolean b = false;
//		boolean c = a && b;
//		// a = true, b = false, c = false
//		System.out.println("a = " + a + "," + " b = " +  b + "," + " c = " +  c);

//		short a = 12345;
//		byte b = (byte)a;
//		System.out.println("a = " + a + "," + " b = " +  b);
		
		// 按位取反 ~n = -(n+1)
//		int a = 5;//0b0000_0001
//		int b = ~a;
//		// a = 2, b = -3
//		// a = -2, b = 1
//		System.out.println("a = " + a + "," + " b = " +  b);
		
		
		// >> 有符号右移(最左用符号位补齐)
		// >>> 无符号右移(最左用0补齐)
		byte a = 5;// 00000101、11111011
		byte b = (byte) (a>>>1);// 2147483645 、 1073741822
		// a>>1 5:0b0101 --> 2:0010
		// a>>2 5:0b0101 --> 1:0001
		// a>>1 -5:0b1011（补码） --> -3:1101（补码）
		// a>>2 -5:0b1011（补码） --> -2:1110（补码）
		// a>>>1 5:0b0101（补码） --> 2:0010（补码）
		// a>>>2 5:0b0101（补码） --> 1:0001（补码）
		// a>>>1 -5:0b1011（补码） --> 2147483645:1101（补码）
		// a>>>2 -5:0b1011（补码） --> 1073741822:1110（补码）
		// a<<1 5:0b0101（补码） --> 10:0b1010（补码）
		// a<<2 5:0b0101（补码） --> 20:0b1_0100（补码）
		// a<<1 -5 --> -10
		// a<<2 -5 --> -20
		System.out.println(b);
		
		
		
	}
}

