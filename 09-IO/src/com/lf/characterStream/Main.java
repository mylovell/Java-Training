package com.lf.characterStream;

import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		// 字符流
		printFile("/Users/fengluo/Desktop/123/5/05.txt");

	}
	

	// 将文本文件的内容逐个字符打印出来
	public static void printFile(String filePath) {
		
		File file = new File(filePath);
		try (FileReader reader = new FileReader(file)) {
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
				Thread.sleep(100);
			}
		} catch (Exception e) {}
		
	}

}
