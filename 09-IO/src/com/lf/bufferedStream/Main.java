package com.lf.bufferedStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws IOException {
		
//		bufferedMethod();
//		printByLine();
		
//		changeEncode();
		
		systemIn();
		
	}



	private static void systemIn() throws IOException {
		// 接收控制台的输入
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
		
	}



	private static void changeEncode() {
		try (
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
						new FileInputStream("/Users/fengluo/Desktop/123/5/05.txt"), "UTF-8")
						);
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(
						new FileOutputStream("/Users/fengluo/Desktop/123/5/05_GBK.txt"), "GBK")
						);
		) {
			char[] chars = new char[1024];
			int len;
			while ((len = reader.read(chars)) != -1) { writer.write(chars, 0, len); }
		} catch (Exception e) {}
	}



	private static void printByLine() {
		try (BufferedReader reader = new BufferedReader(new FileReader("/Users/fengluo/Desktop/123/5/05.txt"));) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				Thread.sleep(200);
			}
		} catch (Exception e) {
		}
	}
	
	

	private static void bufferedMethod() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/fengluo/Desktop/123/5/06.txt"));
		writer.write("223");
		writer.newLine();
		writer.write("334");
//		writer.flush();
		writer.close();
	}

}
