package com.lf.byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.events.Comment;

import com.lf.file.*;

public class Main {

	// 字节流
	public static void main(String[] args) {
		
//		write("234罗峰", "/Users/fengluo/Desktop/123/4/01.txt");
		
//		String fileContent = readFileContent("/Users/fengluo/Desktop/123/4/01.txt");
//		System.out.println(fileContent);
		
//		copy("/Users/fengluo/Desktop/123/4/01.txt", "/Users/fengluo/Desktop/123/5/05.txt");
		
		
		
	}
	
	// 写入字符串数据
	public static void write(String content, String pathName) {
		if (content == null || content.length() == 0 
			|| pathName == null || pathName.length() == 0) return;
		byte[] bytes = content.getBytes();
		File file = new File(pathName);
		
		write(bytes, file);
	}
	
	// 可以写入任何数据
	public static void write(byte[] data, File file) {
		if (data == null || file == null || file.exists()) return;
		Files.mkparents(file);
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			fos.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String readFileContent(String pathName) {
		byte[] bytes = read(new File(pathName));
		return new String(bytes);
	}
	
	public static byte[] read(String pathName) {
		return read(new File(pathName));
	}
	
	//	根据文件，读取二进制字节，所以这里不用考虑编码问题
	public static byte[] read(File file) {
		if (file == null || !file.exists() || file.isDirectory()) return null;
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] bytes = new byte[ (int)file.length() ];
			fis.read(bytes);
			return bytes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void copy(String srcName, String destName) {
		if (srcName == null || destName == null) return;
		if (srcName.length() == 0 || destName.length() == 0) return;
		copy(new File(srcName), new File(destName));
	}
	
	// 只复制文件，非文件夹
	public static void copy(File src, File dest) {
		if (src == null || dest == null) return;
		if (!src.exists() || dest.exists()) return;
		if (src.isDirectory()) return;
		Files.mkparents(dest);
		
		
		try (FileInputStream is = new FileInputStream(src); FileOutputStream os = new FileOutputStream(dest);) {
			byte[] data = new byte[8192];
			int len;
			while ((len = is.read(data)) != -1) {
				os.write(data, 0, len);
			}
		} catch (Exception e) {
		}
		
//		FileInputStream is = null;
//		FileOutputStream os = null;
//		try {
//			is = new FileInputStream(src);
//			os = new FileOutputStream(dest);
//			byte[] data = new byte[8192];
//			int len;
//			while ((len = is.read(data)) != -1) { os.write(data, 0, len); }
//		} catch (FileNotFoundException e) {} catch (IOException e) {}
//		finally {
//			if (is != null) { try { is.close(); } catch (IOException e) {} }
//			if (os != null) { try { os.close(); } catch (IOException e) {} }
//		}
	}
	
	
	
}
