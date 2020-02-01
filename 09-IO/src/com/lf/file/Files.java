package com.lf.file;

import java.io.File;
import java.util.function.Consumer;

public class Files {
	
	private static void mkparents(File file) {
		File parent = file.getParentFile();
		if (parent.exists()) return;
		parent.mkdirs();
	}
	
	public static void move(File src, File dest) {
		if (src == null || dest == null) return;
		if (!src.exists() || dest.exists()) return;
		mkparents(dest);
		src.renameTo(dest);
	}
	
	private static void clean(File dir) {
		if (dir == null || !dir.exists() || dir.isFile()) return;
		File[] subfiles = dir.listFiles();
		for (File sf : subfiles) {
			delete(sf);
		}
	}
	
	public static void delete(File file) {
		if (file == null || !file.exists()) return;
		clean(file);
		file.delete();
	}
	
	public static void search(File dir, Consumer<File> operation) {
		if (dir == null || operation == null) return;
		if (!dir.exists() || dir.isFile()) return;
		
		File[] subFiles = dir.listFiles();
		for (File sf : subFiles) {
			
			operation.accept(sf);
			
			if (sf.isFile()) continue;
			search(sf, operation);
		}
	}
	
	public static void main(String[] args) {
		
//		search(new File("/Users/fengluo/Desktop/Jicheng/"), (file) -> {
//			System.out.println(file);
//		});
		
//		move(new File("/Users/fengluo/Desktop/123/3/4"), new File("/Users/fengluo/Desktop/123/2/4"));
		
//		delete(new File("/Users/fengluo/Desktop/123/3/4"));
		
	}
}
