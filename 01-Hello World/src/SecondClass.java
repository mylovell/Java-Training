
public class SecondClass {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("SecondClass - Hello World!");
		

		
		// & | ^ ：都没有短路功能
		// & 都是真才
		// | 一个为真即可
		// ^ 不相等才是真
//		int age1 = 0b10010;
//		int age2 = 0b11111;
//		System.out.println(age1&age2);
//		System.out.println(age1|age2);
//		System.out.println(age1^age2);
		
		System.out.println("-------");
		
//		char c = 'A';// ASCII 为 65
//		System.out.println(c);
//		System.out.println(+c);// char提升为int
//		
//		byte b = 11;
//		System.out.println(~b);// 提升为int
		
		System.out.println("-------");
		
		int[] arr5 = {11,21,31,41};
		System.out.println(arr5);
		System.out.println(arr5.hashCode());
		System.out.println(0x27c170f0);
//		for (int i : arr5) {
//			System.out.println(i);
//		}
		
//		int[] arr6 = new int[4];
//		arr6[0] = 1;
//		arr6[1] = 2;
//		arr6[2] = 3;
//		arr6[3] = 4;
//		System.out.println(arr6);
		
	}

}
