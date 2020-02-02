package com.lf.file;

import java.io.File;
import java.util.function.Consumer;

public class Files {
	
	public static void mkparents(String pathname) {
		File file = new File(pathname);
		mkparents(file);
	}
	
	public static void mkparents(File file) {
		File parent = file.getParentFile();
		// 不能写parent.exists()，因为最顶端的目录没parent，为null，调用方法报错
		if (parent == null) return;
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
