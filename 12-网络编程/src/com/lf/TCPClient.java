package com.lf;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// 服务器的地址和端口号 127.0.0.1 、 192.168.0.13
		Socket socket = new Socket("127.0.0.1", 8888);
		OutputStream os = socket.getOutputStream();
		
		os.write("777".getBytes("UTF-8"));
		
		socket.close();
		
	}
}
