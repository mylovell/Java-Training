package com.lf.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
//		separator();
//		fileMethod1();
		getAbsolute();
//		list();
//		listFilter();
//		listFiles();
//		delete();
//		createNewFileOrDir();
		
		
		
	}

	private static void createNewFileOrDir() {
		File file = new File("/Users/fengluo/Desktop/123/456");
//		boolean isCreate = file.createNewFile();
//		boolean isCreate = file.mkdir();
//		boolean isCreate = file.mkdirs();
		// 剪切并重命名
		boolean isCreate = file.renameTo(new File("/Users/fengluo/Desktop/123/2/789"));
		System.out.println("result：" + isCreate);
	}

	private static void delete() {
		File file = new File("/Users/fengluo/Desktop/123/45");
		System.out.println("exists：" + file.exists());// true
		System.out.println("isDirectory：" + file.isDirectory());// true
		System.out.println(file.isFile());// false
		System.out.println(file.isHidden());// false
		System.out.println("canWrite：" + file.canWrite());// true
		
		boolean isDel = file.delete();
		System.out.println("isDel：" + isDel);
	}

	private static void listFiles() {
		File file = new File("/Users/fengluo/Desktop/Jicheng/");
		File[] files = file.listFiles();
		
		/*
		 [
		 /Users/fengluo/Desktop/Jicheng/Jicheng.xcodeproj, 
		 /Users/fengluo/Desktop/Jicheng/.DS_Store, 
		 /Users/fengluo/Desktop/Jicheng/Jicheng
		 ]
		 */
		System.out.println(Arrays.toString(files));
	}

	private static void listFilter() {
		File file = new File("/Users/fengluo/Desktop/Jicheng/");
		String[] files = file.list((dir, name) -> {
			return name.startsWith("J");
		});
		/*
		[
		Jicheng.xcodeproj, 
		Jicheng
		]
		 */
		System.out.println(Arrays.toString(files));
	}

	private static void list() {
		File file = new File("/Users/fengluo/Desktop/Jicheng/");
		String[] files = file.list();
		/*
		[
		Jicheng.xcodeproj, 
		.DS_Store, 
		Jicheng
		]
		 */
		System.out.println(Arrays.toString(files));
	}

	private static void getAbsolute() {
		
		File file = new File("11.txt");
		
		// 11.txt
		System.out.println("获取路径：" + file.getPath());
		
		// /Users/fengluo/Documents/Java①/Code/09-IO/11.txt
		System.out.println("绝对路径：" + file.getAbsolutePath());
		
		// /Users/fengluo/Documents/Java①/Code/09-IO/11.txt
		System.out.println("绝对路径形式的文件：" + file.getAbsoluteFile());
		// /Users/fengluo/Documents/Java①/Code/09-IO
		System.out.println("父路径：" + file.getAbsoluteFile().getParent());
		// null
		System.out.println("父路径(有坑)：" + file.getParent());
		System.out.println("父路径文件夹(有坑)：" + file.getParentFile());
	}

	private static void fileMethod1() {
		File file = new File("/Users/fengluo/Desktop/Jicheng/Jicheng.xcodeproj");
		
		// 文件名称：Jicheng.xcodeproj
		System.out.println("文件名：" + file.getName());
		// /Users/fengluo/Desktop/Jicheng
		System.out.println("父路径：" + file.getParent());
		// /Users/fengluo/Desktop/Jicheng
		System.out.println("父文件：" + file.getParentFile());
		
		// /Users/fengluo/Desktop/Jicheng/Jicheng.xcodeproj
		System.out.println("获取路径：" + file.getPath());
		// /Users/fengluo/Desktop/Jicheng/Jicheng.xcodeproj
		System.out.println("绝对路径：" + file.getAbsolutePath());
		// /Users/fengluo/Desktop/Jicheng/Jicheng.xcodeproj
		System.out.println("绝对路径形式的文件：" + file.getAbsoluteFile());
		
		// 1579161401530
		System.out.println("最后一次修改时间：" + file.lastModified());
		// 160
		System.out.println("文件大小（不支持文件夹大小）：" + file.length());
	}

	private static void separator() {
		File file = new File("F:" + File.separator + "Files" + File.separator + "1.txt");
		// F:/Files/1.txt
		System.out.println(file);
	}

}

