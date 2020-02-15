
package com.lf.进制转换;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 目前只支持整数
 * 不支持浮点数
 * 不支持下划线
 * @author fengluo
 *
 */
@SuppressWarnings("serial")
public class DigitChangeFrame extends JFrame {
	
	private int tfW = 25;
	
	public static void main(String[] args) {
		
		new DigitChangeFrame().setVisible(true);
		
		
		
//		// 字符串二进制转十进制
//		String binary = "1111";
////		BigInteger bi = new BigInteger(binary, 2);
////		Integer result = Integer.parseInt(bi.toString());
////		System.out.println(result);
//		Long result = Long.valueOf(binary, 2);
//		System.out.println(result);
//		
//		// 字符串二进制转十六进制
//		String hexString = Long.toHexString(result);
//		System.out.println(hexString);
		
	}
	
	public DigitChangeFrame() {
		this("进制转换");
	}
	
	public DigitChangeFrame(String string) {
		super(string);
		
		// x,y是针对桌面左上角
		this.setBounds(50, 50, 500, 400);
		// 点击关闭时，程序停止
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 流水布局，LEFT从左到右，垂直方向距离15、水平方向距离15
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		// 字体
		Font font = new Font("微软雅黑", Font.PLAIN, 16);
		
		
		// 文本输入框
		JTextField tf0 = new JTextField(tfW);
		tf0.setFont(font);
		this.add(tf0);
		//按钮
		JButton btn1 = new JButton("转换");
		btn1.setFont(font);
		this.add(btn1);
		
		
		
		// 提示 标签
		JTextField tipTF = new JTextField(tfW + 5);
		tipTF.setFont(font);
		tipTF.setEditable(false);
		tipTF.setText("提示：");;
		this.add(tipTF);
		
		
		// 二进制 标签
		JLabel label1 = new JLabel("二进制：");
		label1.setFont(font);
		this.add(label1);
		// 文本输入框
		JTextField tf1 = new JTextField(tfW);
		tf1.setEditable(false);
		tf1.setFont(font);
		this.add(tf1);
		
		// 十进制 标签
		JLabel label2 = new JLabel("十进制：");
		label2.setFont(font);
		this.add(label2);
		// 文本输入框
		JTextField tf2 = new JTextField(tfW);
		tf2.setEditable(false);
		tf2.setFont(font);
		this.add(tf2);
		
		// 十六进制 标签
		JLabel label3 = new JLabel("16进制：");
		label3.setFont(font);
		this.add(label3);
		// 文本输入框
		JTextField tf3 = new JTextField(tfW);
		tf3.setEditable(false);
		tf3.setFont(font);
		this.add(tf3);
		
		// 8进制 标签
		JLabel label4 = new JLabel("八进制：");
		label4.setFont(font);
		this.add(label4);
		JTextField tf4 = new JTextField(tfW);
		tf4.setEditable(false);
		tf4.setFont(font);
		this.add(tf4);
		
		// 提示 标签
		JLabel tipL = new JLabel("提示：");
		tipL.setFont(font);
		this.add(tipL);
		
		
		
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String content = tf0.getText();
				
				if (content == null || content.equals("")) {
					tipL.setText("提示：请输入值");
					tipTF.setText("提示：请输入值");
					return;
				}
				
				if (content.contains(".")) {
					tipL.setText("提示：暂不支持浮点数");
					tipTF.setText("提示：暂不支持浮点数");
					return;
				}
				

				if (content.matches("[0-9]+[l]?")) {
					tipL.setText("提示：十进制");
					tipTF.setText("提示：十进制");
					
					if (content.endsWith("l")) {
						content = content.substring(0, content.length()-1);
					}

//					String binary = decimalToBinary(content);
//					String hex = decimalToHex(content);
					
					// 转成十进制先
					Long long1 = Long.valueOf(content, 10);
					String binary2 = Long.toString(long1,2);
					String hex2 = Long.toString(long1,16);
					String oct2 = Long.toString(long1,8);
					
					tf1.setText(binary2);
					tf2.setText(content);
					tf3.setText(hex2);
					tf4.setText(oct2);
					
					return;
				}
				
				if (content.matches("0b[0-1]+")) {
					tipL.setText("提示：二进制");
					tipTF.setText("提示：二进制");
					
					Long value = binaryToDecimal(content);
					String hexString = binaryToHex(content);
					tf1.setText(content);
					tf2.setText(value.toString());
					tf3.setText(hexString);
					tf4.setText(Long.toString(value, 8));
					return;
				}
				
				if (content.matches("0x[0-9a-f]+")) {
					tipL.setText("提示：16进制");
					tipTF.setText("提示：16进制");
					
					Long long1 = hexToDecimal(content);
					String binary = hexToBinary(content);
					
					tf1.setText(binary);
					tf2.setText(long1.toString());
					tf3.setText(content);
					tf4.setText(Long.toString(long1, 8));
					return;
				}
				
				tipL.setText("提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
				tipTF.setText("提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
				
			}
		};
		
		btn1.addActionListener(l);
		
	}
	
	private static Long binaryToDecimal(String value) {
//		BigInteger bi = new BigInteger(binary, 2);
//		Long result = Long.parseInt(bi.toString());
		if (value.startsWith("0b")) {value = value.substring(2);}
		Long longValue = Long.valueOf(value,2);//value是二进制
		return longValue;
	}
	
	private static String binaryToHex(String value) {
		Long longValue = binaryToDecimal(value);
		String longString = Long.toString(longValue,16);
		return longString;
	}
	
	private static String decimalToBinary(String value) {
		Long long1 = Long.valueOf(value);
		String string = Long.toString(long1, 2);
		return string;
	}
	
	private static String decimalToHex(String value) {
		Long long1 = Long.valueOf(value);
		String string = Long.toString(long1, 16);
		return string;
	}
	
	private static Long hexToDecimal(String value) {
		if (value.startsWith("0x")) {value = value.substring(2);}
		Long long1 = Long.valueOf(value, 16);
		return long1;
	}

	private static String hexToBinary(String value) {
		Long long1 = hexToDecimal(value);
		String string = Long.toString(long1, 2);
		return string;
	}
	
	
}
