package com.lf.genericType;

public class Main {

	public static void main(String[] args) {
		
//		genericType();
// 		多个类型参数();
 		
 		Box<String> strBox = new Box<>();
 		Box<Integer> intBox = new Box<Integer>();
 		Box<Object> objBox = new Box<Object>();
// 		strBox = intBox;
// 		objBox = strBox;
		
 		objBox.setElement(new Object());
 		String str = strBox.getElement();
 		System.out.println(str);
 		
	}

	private static void 多个类型参数() {
		
		StudentA<String, String> s1 = new StudentA<String, String>("E9527", "A++");
		System.out.println(s1.getScore() + "、" + s1.getNo());
		// A++、E9527

 		StudentA<Integer, Double>s2 = new StudentA<Integer, Double>(18,96.5);
 		System.out.println(s2.getScore() + "、" + s2.getNo());
 		// 96.5、18
	}

	private static void genericType() {
		
		Student<String> stu1 = new Student<>();
		stu1.setScore("A");
		String score1 = stu1.getScore();
		System.out.println(score1);// A
		
		Student<Double> stu2 = new Student();
		stu2.setScore(98.6);
		Double score2 = stu2.getScore();
		System.out.println(score2);//98.6
	}
	

}
