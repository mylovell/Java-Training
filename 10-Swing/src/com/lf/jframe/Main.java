package com.lf.jframe;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("我是窗口");
		frame.setBounds(200,200,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
