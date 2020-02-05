package com.lf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {

		// 0 ~ 65000多
		try (ServerSocket server = new ServerSocket(8888);){
			while (true) {// while循环，保证持续不停的接收
				Socket client = server.accept();// 这行代码是阻塞式的（监听）
				new Thread(() -> {// 使用多线程，避免多个请求而导致没有接收到
					try {
						doClient(client);
						client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}).start();
				
			}
		}
		
	}
	
	static void doClient(Socket client) throws Exception {
		try (
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
		){
			// 读取客户端的数据
			byte[] buffer = new byte[8192];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			byte[] bytes = baos.toByteArray();
			String content = new String(bytes, "UTF-8");
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.format("服务器接收到客户端[%s]的数据:%s%n",clientIP, content);
			
			// 写数据给客户端
			os.write(doString(content).getBytes("UTF-8"));
		}
	}
	
	static String doString(String str) {
		str = str.replace("你", "朕");
		str = str.replace("吗", "");
		str = str.replace("么", "");
		str = str.replace("?", "!");
		return str;
	}
	
    static void test() throws IOException {
		// 0 ~ 65000多
//		ServerSocket serverSocket = new ServerSocket(8888);
//		// 这行代码是阻塞式的（监听）
//		Socket socket = serverSocket.accept();
//
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		InputStream is = socket.getInputStream();
//		byte[] buffer = new byte[8192];
//		int len;
//		while ((len = is.read(buffer)) != -1) {
//			baos.write(buffer, 0, len);
//		}
//		byte[] bytes = baos.toByteArray();
//		
//		String string = new String(bytes, "UTF-8");
//		System.out.format("服务器接收到客户端[%s]的数据:%s%n",socket.getInetAddress(),string);
//		
//		is.close();
//		socket.close();
//		serverSocket.close();
	}
	
}
