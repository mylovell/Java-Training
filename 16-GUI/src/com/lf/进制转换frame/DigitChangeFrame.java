
package com.lf.进制转换frame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * 目前只支持整数
 * 支持(正)负整数
 * 		-【正负整数转成十六进制没问题，但负的十六进制转整数有问题，Long.parseLong和Long.valueOf只认正数，解决如下】
 * 		-【负十六进制 <--> 十进制整数，用 BigInteger 】
 * 		-【负二进制 <--> 十进制整数，要用 BigInteger (有坑，先转Long，再String，勿直接String)】
 * 不支持检测超出Long最大值【二、十、十六进制之间的大小比较，可用 BigInteger 】
 * 不支持浮点数
 * 支持下划线
 * @author fengluo
 *
 */
@SuppressWarnings("serial")
public class DigitChangeFrame extends JFrame {
	
	private int tfW = 50;
	
	public static void main(String[] args) {
		
//		new DigitChangeFrame().setVisible(true);
		
//		System.out.println(Long.MAX_VALUE);// 9223372036854775807
//		System.out.println(Long.MIN_VALUE);// -9223372036854775808

		// 如何比较超过Long最大值的数 ———— 用BigDecimal
//		Long long1 = Long.valueOf("9223372036854775807");
//		BigDecimal b1 = new BigDecimal("9223372036854775807");
//		BigDecimal b2 = new BigDecimal("92233720368547758091");
//		int b = b1.compareTo(b2);
//		System.out.println(b);
		
		
		// (正)负二进制 --> 十进制
//		String s = "11111111111111111111111111111111";
//		Long long1 = new BigInteger(s, 2).longValue();
//		System.out.println(long1);
		
		// 负数十六进制 --> 十进制
//		String string = "fffffffffffffff6";// -10 16进制字符串前面不能加 0x
//		long long1 = new BigInteger(string, 16).longValue();
//		System.out.println(long1);
		// -11 fffffffffffffff5
		// -10 fffffffffffffff6 0b1111111111111111111111111111111111111111111111111111111111110110
//		BigInteger long0 = new BigInteger("fffffffffffffff5", 16);
//		BigInteger long1 = new BigInteger("11111111111111111111111111111111", 2);
//		int in = long0.compareTo(long1);
//		System.out.println(in);
		
		
		
		// 用 BigInteger 各种进制之间转（注意：负2、16进制转10进制有坑）
//		BigInteger bi = new BigInteger("-10", 10);
//		String binary = bi.toString(2);
//		String decimal = ((Long)bi.longValue()).toString();// (负十六进制)负二进制 --> 十进制，的正确方法
//		String hex = bi.toString(16);
//		String oct = bi.toString(8);
//		System.out.println(binary);
//		System.out.println(decimal);
//		System.out.println(hex);
//		System.out.println(oct);
		
		
		
		// (正)负整数 --> 二进制、十六进制
//		Long integer = Long.valueOf(-10);
//		System.out.println( Long.toBinaryString(integer));
//		System.out.println( Long.toHexString(integer));
		
		
	}
	
	public DigitChangeFrame() {
		this("进制转换2.0");
	}
	
	public DigitChangeFrame(String string) {
		super(string);
		
		// x,y是针对桌面左上角
		this.setBounds(50, 50, 900, 400);
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
		
		// TextField 提示
		JTextField tipTF = new JTextField(tfW);
		tipTF.setFont(font);
		tipTF.setEditable(false);
		tipTF.setText("提示：");
		tipTF.setSize(300, 200);
		this.add(tipTF);
		JButton tipBtn = new JButton("_");
		this.add(tipBtn);
		
		// 监听 tf0 的输入
		KeyAdapter kl = new KeyAdapter() {
            public void keyTyped(KeyEvent k) {
            	
                int x= tf0.getText().length();
                
                if(x>3) {
                	tipTF.setText("提示：数字过长");
                }else {
                	tipTF.setText("提示：++++");
                }
            }
        };
		tf0.addKeyListener(kl);
		
		
		// 二进制 标签
		JLabel label1 = new JLabel("二进制：");
		label1.setFont(font);
		this.add(label1);
		JTextField tf1 = new JTextField(tfW);
		tf1.setEditable(false);
		tf1.setFont(font);
		this.add(tf1);
		
		// 十进制 标签
		JLabel label2 = new JLabel("十进制：");
		label2.setFont(font);
		this.add(label2);
		JTextField tf2 = new JTextField(tfW);
		tf2.setEditable(false);
		tf2.setFont(font);
		this.add(tf2);
		
		// 十六进制 标签
		JLabel label3 = new JLabel("16进制：");
		label3.setFont(font);
		this.add(label3);
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
				
				if (content.matches("0b[0-1]+[Ll]?")) {
					tipL.setText("提示：二进制");
					tipTF.setText("提示：二进制");
					
					Long value = binaryToDecimal(content);
					String hexString = binaryToHex(content);
					
					tf1.setText(content);
					tf2.setText(value.toString());
					tf3.setText("0x" + hexString);
					tf4.setText("0" + Long.toOctalString(value));
					return;
				}
				
				
				if (content.matches("[+-]?[0-9]+[Ll]?")) {
					tipL.setText("提示：十进制");
					tipTF.setText("提示：十进制");
					
					if (content.matches("\\d+[Ll]+")) {
						tipL.setText("提示：十进制长整型");
						tipTF.setText("提示：十进制长整型");
						content = content.substring(0, content.length()-1);
					}
					
					
//					String binary = decimalToBinary(content);
//					String hex = decimalToHex(content);

					// 转成十进制先
					Long long1 = Long.valueOf(content, 10);//可消掉前面的无效0
					System.out.println(long1.toString());
					String binary2 = "0b" + Long.toBinaryString(long1);
//					String binary2 = "0b" + decimalToBinary(content);
					String hex2 = "0x" + Long.toHexString(long1);
//					String hex2 = "0x" + decimalToHex(content);
					String oct2 = "0" + Long.toOctalString(long1);
					
					tf1.setText(binary2);
					tf2.setText(long1.toString());
					tf3.setText(hex2);
					tf4.setText(oct2);
					
					return;
				}
				
				if (content.matches("0x[0-9a-f]+")) {
					tipL.setText("提示：16进制");
					tipTF.setText("提示：16进制");
					
					String binary = hexToBinary(content);
					Long decimalL = hexToDecimal(content);
					
					tf1.setText("0b" + binary);
					tf2.setText(decimalL.toString());
					tf3.setText(content);
					tf4.setText("0" + Long.toOctalString(decimalL));
					return;
				}
				
				tipL.setText("提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
				tipTF.setText("提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
				
			}
		};
		btn1.addActionListener(l);
		
		ActionListener tipBtnL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tipBtn.setSelected(!tipBtn.isSelected());
				StringBuilder s1 = new StringBuilder(tf1.getText());
				StringBuilder s2 = new StringBuilder(tf2.getText());
				StringBuilder s3 = new StringBuilder(tf3.getText());
				StringBuilder s4 = new StringBuilder(tf4.getText());
				
				if (!tipBtn.isSelected()) {
					tf1.setText(tf1.getText().replaceAll("_", ""));
					tf2.setText(tf2.getText().replaceAll("_", ""));
					tf3.setText(tf3.getText().replaceAll("_", ""));
					tf4.setText(tf4.getText().replaceAll("_", ""));
				} else {
					
					for (int i = s1.length() - 8; i > 0; i-=8) {
						if (i <= 2) break;
						s1.insert(i, "_");
					}
					
					for (int i = s2.length() - 3; i > 0; i-=3) {
						s2.insert(i, "_");
					}
					
					for (int i = s3.length() - 8; i > 0; i-=8) {
						if (i <= 2) break;
						s3.insert(i, "_");
					}
					
					for (int i = s4.length() - 8; i > 0; i-=8) {
						if (i <= 2) break;
						s4.insert(i, "_");
					}
					
					tf1.setText(s1.toString());
					tf2.setText(s2.toString());
					tf3.setText(s3.toString());
					tf4.setText(s4.toString());
				}
			}
		};
		tipBtn.addActionListener(tipBtnL);
		
	}
	
	private static Long binaryToDecimal(String value) {
		if (value.startsWith("0b")) {value = value.substring(2);}
		if (value.matches("\\w+\\B[lL]\\b")) {value = value.substring(0, value.length()-1);}
		
		Long long1 = new BigInteger(value, 2).longValue();
		return long1;
	}
	
	private static String binaryToHex(String value) {
		if (value.startsWith("0b")) {value = value.substring(2);}
		if (value.matches("\\w+\\B[lL]\\b")) {value = value.substring(0, value.length()-1);}
		
		Long longValue = new BigInteger(value, 2).longValue();
		String longString = Long.toHexString(longValue);
		return longString;
	}
	
	/**
	 * 十进制 --> 二进制
	 * @param value 正负整数的字符串
	 * @return
	 */
	private static String decimalToBinary(String value) {
		
		StringBuilder sb = new StringBuilder();
		Long a = Long.valueOf(value, 10);
		for (int i = 0; i < 64; i++) {
			Long t = (a & 0x8000000000000000L >>> i) >>> (63 - i);
			//System.out.print(t);
			sb.append(t);
			//if ((i+1) % 8 == 0 && (i != 63)) System.out.print("_");
			if ((i+1) % 8 == 0 && (i != 63)) sb.append("_");
		}
		return sb.toString();
		
		// 简便方法
//		Long long1 = Long.valueOf(value);
////		String string = Long.toString(long1, 2);// 无法处理负整数
//		String string = Long.toBinaryString(long1);
//		return string;
	}
	
	private static String decimalToHex(String value) {
		Long long1 = Long.valueOf(value);
		String string = Long.toOctalString(long1);
		return string;
	}
	
	private static Long hexToDecimal(String value) {
		
		if (value.startsWith("0x")) {value = value.substring(2, value.length());}
		if (value.matches("\\w+[lL]")) {value = value.substring(0, value.length()-1);}
//		Long long1 = Long.valueOf(value, 16); // 无法处理负数十六进制
//		long long1 = Long.parseLong(value, 16); // 无法处理负数十六进制
		Long long1 = (Long)(new BigInteger(value, 16).longValue());//先转为Long，再转string，才先显示对的字符串
		return long1;
	}

	private static String hexToBinary(String value) {
		Long long1 = hexToDecimal(value);
//		String string = Long.toString(long1, 2);//只对正数有用
		String string = Long.toBinaryString(long1);
		return string;
	}
	
	
}
