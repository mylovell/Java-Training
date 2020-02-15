package com.lf.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、写入字符内容到文件
 * 2、从文件读取字符内容，打印到控制台
 * 3、复制src文件到dst文件
 * 4、剪切src文件到dst文件
 * @author fengluo
 *
 */
public class Files {

//	public static void main(String[] args) {
////		read("/Users/fengluo/Desktop/123/2/4/4.txt");
////		read("/Users/fengluo/Desktop/123/4/01.txt");
//		
////		write("hello world", "/Users/fengluo/Desktop/123/2/4/1.txt");
//		
////		copy("/Users/fengluo/Desktop/123/2/4/1.txt", "/Users/fengluo/Desktop/123/2/4/2.txt");
//		
//		move("/Users/fengluo/Desktop/123/2/4/3.txt", "/Users/fengluo/Desktop/123/2/3.txt");
//	}
	
	/**
	 * 读取文件，打印内容到控制台
	 * @param pathname 文件全路径
	 */
	public static void read(String pathname) {
		File file = new File(pathname);
		read(file);
	}
	
	private static void read(File file) {
		try (
			FileInputStream fis = new FileInputStream(file);
		){
			byte[] bytes = new byte[8192];
			while ((fis.read(bytes)) != -1) {
				String string = new String(bytes);
				System.out.println(string);
			}
		} catch (Exception e) {}
		
	}
	
	/**
	 * 写入一段字符串到文件中，覆盖操作
	 * @param content 字符串内容
	 * @param pathname 文件绝对路径
	 */
	public static void write(String content, String pathname) {
		File file = new File(pathname);
		write(content, file);
	}
	
	private static void write(String content, File file) {
		
		try (
			FileOutputStream fos = new FileOutputStream(file);
		){
			byte[] bytes = content.getBytes("UTF-8");
			fos.write(bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 复制操作
	 * @param scrPath 源路径，要求绝对路径
	 * @param dstPath 目标路径，要求绝对路径
	 */
	public static void copy(String scrPath, String destPath) {
		File scr = new File(scrPath);
		File dest = new File(destPath);
		
		if (scr == null || dest == null) return;
		if (!scr.exists()) { System.out.println("源路径不存在，终止操作！"); return;} //源不存在或目标已存在，都终止
		if (dest.exists()) { System.out.println("目标已存在，无需复制，终止操作！"); return;} 
		
		mkparents(dest);
		copy(scr, dest);
		
	}
	
	/* 复制：
	 * 从scr读取到内存，同时，从内存写入到dest；
	 */
	private static void copy(File scr, File dest) {
		
		try (
			FileInputStream fis = new FileInputStream(scr);
			FileOutputStream fos = new FileOutputStream(dest);
		){
			int len;
			byte[] bytes = new byte[8192];
			while ((len = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 剪切操作
	 * @param scrPath 源全路径
	 * @param destPath 目标全路径
	 */
	public static void move(String scrPath, String destPath) {
		File scr = new File(scrPath);
		File dest = new File(destPath);
		move(scr, dest);
	}
	
	private static void move(File scr, File dest) {
		
		if (scr == null || dest == null) return;
		if (!scr.exists()) { System.out.println("源路径不存在，终止操作！"); return; }
		if (dest.exists()) { System.out.println("目标已存在，无需复制，终止操作！"); return; }
		
		mkparents(dest);
		scr.renameTo(dest);
	}
	
	/**
	 * 创建文件的父路径
	 * @param file 要求路径为全路径（绝对路径，不支持相对路径）
	 */
	public static void mkparents(File file) {
		File parent = file.getParentFile();
		if (parent == null) return;//顶级路径没父路径了
		parent.mkdirs();
	}

}
