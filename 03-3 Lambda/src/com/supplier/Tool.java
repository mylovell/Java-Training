package com.supplier;

public class Tool {

	
	public void run() {
		
		String s1 = "";
		String s2 = "B";
		String s3 = "C";
		
		String string = getFirstNotEmptyString(s1, () -> s1 + s2 + s3);
		System.out.println(string);
	}
	
	
	String getFirstNotEmptyString(String s1, Supplier<String> s2) {
		if (s1 != null && s1.length() != 0) return s1;
		if (s2 == null) return null;
		String str = s2.get();
		return (str != null && str.length() != 0) ? str : null;
	}
	

}
