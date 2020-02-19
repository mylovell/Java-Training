
package com.lf.进制转换frame;

import static com.lf.进制转换frame.DigitChangeFrame.hexConvert;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* 测试：（二 十 十六）6种组合，每中组合有11（10）种情况
 * ①二 十
 * 1、（正）超Long最大值（一律判为超出64位）
 * 2、（正）Long最大值
 * 3、（正）Long类型
 * 4、（正）Integer最大值
 * 5、（正）Integer类型
 * 6、零
 * 7、（负）Integer类型
 * 8、（负）Integer最小值
 * 9、（负）Long类型
 * 10、（负）Long最小值
 * 11、（负）超Long最小值（一律判为超出64位）
 * 
 * ②二 十六
 * 
 * ③十 二
 * 
 * ④十 十六
 * 
 * ⑤十六 二
 * 
 * ⑥十六 十
 * 
 */

/* 需求
 * 
 * 二进制、十进制、十六进制之间，整数转换，需满足一下几个条件：
 * 1、正数转；
 * 2、负数转；（这个不要忘了）
 * 3、区分Integer和Long类型的数；（这个要注意，否则转出来的数据有问题）
 * 4、检测超出Long取值范围；
 * 5、(可选)识别符号：前缀0b、前缀0x、中间下划线、末尾l和L。
 * 6、(可选)实时检测：数据类型、数据位数。
 * 7、不支持浮点数
 * 
 */

/**
 * 目前只支持整数
 * 支持(正)负整数( BigInteger用于各进制之间的转换，BigDecimal用与比较大小计算 )
 * 		-【正负整数转成十六进制没问题，但负的十六进制转整数有问题，Long.parseLong和Long.valueOf只认正数，解决如下】
 * 		-【负十六进制 <--> 十进制整数，用 BigInteger 】
 * 		-【负二进制 <--> 十进制整数，要用 BigInteger (有坑，先转Long，再String，勿直接String)】
 * 支持检测超出Long取值范围【二、十、十六进制之间的大小比较，可用 BigInteger 】
 * 不支持浮点数
 * 支持下划线
 * @author fengluo
 *
 */
@SuppressWarnings("serial")
public class DigitChangeFrame extends JFrame {
	
	private int tfW = 50;
	
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);// +2147483647 0x7fffffff  0b1111111111111111111111111111111
//		System.out.println(Integer.MIN_VALUE);// -2147483648 0x80000000 0b10000000000000000000000000000000
//		System.out.println(Long.MAX_VALUE);// +9223372036854775807 0x7fffffffffffffffL  0b111111111111111111111111111111111111111111111111111111111111111L
//		System.out.println(Long.MIN_VALUE);// -9223372036854775808 0x8000000000000000L 0b1000000000000000000000000000000000000000000000000000000000000000l
		
//		System.out.println(hexConvert("0b1100100l", 10));

//		new DigitChangeFrame().setVisible(true);
		
		

		// 如何比较超过Long最大值的数 ———— 用BigDecimal
//		Long long1 = Long.valueOf("9223372036854775807");
//		BigDecimal b1 = new BigDecimal("9223372036854775807");
//		BigDecimal b2 = new BigDecimal("92233720368547758091");
//		int b = b1.compareTo(b2);
//		System.out.println(b);
		
		
	}
	
	public DigitChangeFrame() {
		this("进制转换3.0 Release");
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
		tipTF.setText("提示：请输入(0b)二进制、十进制、(0x)十六进制的值，64位内存以内");
		tipTF.setSize(300, 200);
		this.add(tipTF);
		JButton tipBtn = new JButton("_");
		this.add(tipBtn);
		
		
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
		JLabel tipL = new JLabel("提示：请输入(0b)二进制、十进制、(0x)十六进制的值，64位内存以内。暂不支持8进制、浮点数。");
		tipL.setFont(font);
		this.add(tipL);
		
		

		// 监听 tf0 的输入
		KeyAdapter kl = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	tipTF.setForeground(Color.black);
            	
                runCalcute(tf0, tf1, tf2, tf3, tf4, tipTF, tipL);
            	
            }
        };
		tf0.addKeyListener(kl);
		
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipBtn.setSelected(false);
				tipTF.setForeground(Color.black);
				
				runCalcute(tf0, tf1, tf2, tf3, tf4, tipTF, tipL);
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
	
	private static void runCalcute(JTextField tf0, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tipTF, JLabel tipL) {
		
		String content = tf0.getText();
		
		if (content == null || content.equals("")) {
			tipTF.setText("提示：请输入(0b)二进制、十进制、(0x)十六进制的值，64位内存以内");
			//"提示：请输入值，二进制以0b开头，十六进制以0x开头");
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			return;
		}
		
		if (content.contains(".")) {
			tipTF.setText("提示：暂不支持浮点数");
			return;
		}
		
		if (content.matches("0b[0-1_]+[Ll]?")) {
			tipTF.setText("提示：二进制");
			
			content = content.replaceAll("(0b)?[_lL]?", "");
			BigInteger bi = new BigInteger(content, 2);
			if (bi.bitLength() > 64) { 
				tipTF.setText("提示：超过64位，重新输入(" + bi.bitLength() + ")");
				tipTF.setForeground(Color.red);
				return;
			} else {
				tipTF.setText("提示：二进制，" + bi.bitLength() + "位");
			}
			
			String decimal = binaryToDecimal(content);
			String hexString = binaryToHex(content);
			
			tf1.setText("0b" + content);
			tf2.setText(decimal.toString());
			tf3.setText("0x" + hexString);
			tf4.setText("0" + Long.toOctalString(bi.longValue()));
			return;
		}
		
		
		if (content.matches("[+-]?[0-9_]+[Ll]?")) {
//			"提示：十进制");
			tipTF.setText("提示：十进制");
			
			content = content.replaceAll("[[+]_lL]", "");
			
			BigInteger bi = new BigInteger(content, 10);
			if (bi.bitLength() > 64) {
				tipTF.setText("提示：超过64位，重新输入(" + bi.bitLength() + ")");
				tipTF.setForeground(Color.red);
				return;
			} else {
				tipTF.setText("提示：十进制，" + bi.bitLength() + "位");
			}
			
			// 转成十进制先
			String binary2 = "0b" + decimalToBinary(content);
			String hex2 = "0x" + decimalToHex(content);
			String oct2 = "0" + Long.toOctalString(bi.longValue());
			
			tf1.setText(binary2);
			tf2.setText(bi.toString(10));//可消掉前面的无效0
			tf3.setText(hex2);
			tf4.setText(oct2);
			
			return;
		}
		
		if (content.matches("0x[0-9a-fA-F_]+[lL]?")) {
//			"提示：16进制");
			tipTF.setText("提示：16进制");
			content = content.replaceAll("(0x)?[_lL]?", "");
			
			BigInteger bi = new BigInteger(content, 16);
			if (bi.bitLength() > 64) { 
				tipTF.setText("提示：超过64位，重新输入(" + bi.bitLength() + ")");
				tipTF.setForeground(Color.red);
				return;
			} else {
				tipTF.setText("提示：16进制，" + bi.bitLength() + "位");
			}
			
			String binary = hexToBinary(content);
			String decimal = hexToDecimal(content);
			
			tf1.setText("0b" + binary);
			tf2.setText(decimal);
			tf3.setText("0x" + content);
			tf4.setText("0" + Long.toOctalString(bi.longValue()));
			return;
		}
		
//		"提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
		tipTF.setText("提示：检查输入的值，必须为2进制、10进制、16进制中的一种");
		
	}
	
	private static String binaryToDecimal(String value) {
		
		value = value.replaceAll("(0b)?[_lL]?", "");
		BigInteger bi = new BigInteger(value,2);
		
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return Integer.toString(int1);
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return Long.toString(long1);
		}
		
	}
	
	private static String binaryToHex(String value) {
		
		value = value.replaceAll("(0b)?[_lL]?", "");
		BigInteger bi = new BigInteger(value,2);
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return Integer.toHexString(int1);
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return Long.toHexString(long1);
		}
	}
	
	/**
	 * 十进制 --> 二进制
	 * @param value 正负整数的字符串
	 * @return
	 */
	private static String decimalToBinary(String value) {
		
//		StringBuilder sb = new StringBuilder();
//		Long a = Long.valueOf(value, 10);
//		for (int i = 0; i < 64; i++) {
//			Long t = (a & 0x8000000000000000L >>> i) >>> (63 - i);
//			//System.out.print(t);
//			sb.append(t);
//			//if ((i+1) % 8 == 0 && (i != 63)) System.out.print("_");
//			if ((i+1) % 8 == 0 && (i != 63)) sb.append("_");
//		}
//		return sb.toString();
		
		// 简便方法
		value = value.replaceAll("[[+]_lL]", "");
		BigInteger bi = new BigInteger(value,10);
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return Integer.toBinaryString(int1);
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return Long.toBinaryString(long1);
		}
		
	}
	
	private static String decimalToHex(String value) {
		value = value.replaceAll("[[+]_lL]", "");
		BigInteger bi = new BigInteger(value,10);
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return Integer.toHexString(int1);
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return Long.toHexString(long1);
		}
		
	}
	
	private static String hexToDecimal(String value) {

		value = value.replaceAll("(0x)?[_lL]?", "");
//		Long long1 = Long.valueOf(value, 16); // 无法处理负数十六进制
//		long long1 = Long.parseLong(value, 16); // 无法处理负数十六进制
		
		BigInteger bi = new BigInteger(value,16);
		// 这里要判断Integer还是Long（否则出错）
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return int1.toString();
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return long1.toString();
		}
		
	}

	private static String hexToBinary(String value) {
		
		value = value.replaceAll("(0x)?[_lL]?", "");
		BigInteger bi = new BigInteger(value,16);
		// 这里要判断Integer还是Long（否则二进制位数出错）
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			return Integer.toBinaryString(int1);
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
			return Long.toBinaryString(long1);
		}
//		String string = Long.toString(long1, 2);//只对正数有用

	}
	
	/**
	 * 以上6个方法的通用方法，支持 二、十、十六进制 之间互转
	 * @param value 二进制以0b开头、十六进制以0x开头、十进制无前缀
	 * @param destRadix 目标进制： 二、十、十六进制
	 * @return 目标进制的字符串
	 */
	static String hexConvert(String value, int destRadix) {
		
		if (value.contains(".")) { System.out.println("暂不支持浮点数"); return null; }
		if (!(destRadix == 2 || destRadix == 10 || destRadix == 16)) { System.out.println("不支持该进制：" + destRadix); return null;}
		
		value = value.replaceAll("[+]", "");// 去掉多余的+
		
		int radix = value.startsWith("0b") ? 2 : value.startsWith("0x") ? 16 : 10;
		
		// 进制识别、分别处理
		if (value.matches("0b[0-1_]+[Ll]?")) {
			value = value.replaceAll("(0b)?[_lL]?", "");
		} else if (value.matches("[+-]?[0-9_]+[Ll]?")) {
			value = value.replaceAll("[[+]_lL]", "");
		} else if (value.matches("0x[0-9a-fA-F_]+[lL]?")) {
			value = value.replaceAll("(0x)?[_lL]?", "");
		} else {
//			System.out.println("不是二、十、十六进制中的一种");
			return null;
		}
//		System.out.println(value);
//		System.out.println("radix :" + radix);
		BigInteger bi = new BigInteger(value,radix);
//		System.out.println("------:" + bi);
		if (bi.bitLength() > 64) return null;
		// 这里要判断Integer还是Long（否则二进制位数出错）
		if (bi.bitLength() <= 32) {
			Integer int1 = (Integer)bi.intValue();//先转为Long，再转string，才先显示对的字符串
			String result = destRadix == 2 ? Integer.toBinaryString(int1) : destRadix == 16 ? Integer.toHexString(int1) : Integer.toString(int1);
//			System.out.println("Integer:" + result);
			return result;
		} else {
			Long long1 = (Long)bi.longValue();//先转为Long，再转string，才先显示对的字符串
//			System.out.println("Long1:" + long1);
			String result = destRadix == 2 ? Long.toBinaryString(long1) : destRadix == 16 ? Long.toHexString(long1) : Long.toString(long1);
//			System.out.println("Long2:" + result);
			return result;
		}
	}
	
}
