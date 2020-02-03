package com.lf.print;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.channels.WritableByteChannel;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String nameString = "FeiFei";
		int age = 20;
		
		PrintWriter wirter = new PrintWriter("/Users/fengluo/Desktop/123/5/07.txt");
		wirter.format("My name is %s, age is %d", nameString, age);
		wirter.close();

	}

}
