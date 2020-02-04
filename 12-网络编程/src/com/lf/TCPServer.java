package com.lf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {

		// 0 ~ 65000多
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = socket.getInputStream();
		byte[] bytes = new byte[8192];
		int len;
		while ((len = is.read(bytes)) != -1) {
			baos.write(bytes, 0, len);
		}
//			socket.getInputStream();

		
		socket.close();
		serverSocket.close();
		
		
	}
}
