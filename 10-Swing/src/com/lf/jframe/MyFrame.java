package com.lf.jframe;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




/**
 * 一个计算器界面
 * @author FengLuo
 *
 */
@SuppressWarnings("serial")// 表示不想生成序列化接口
public class MyFrame extends JFrame {

	/**
	 * 
	 * @param string 窗口的名称
	 */
	public MyFrame(String string) {
		
		super(string);
		// x,y是针对桌面左上角
		this.setBounds(50,50,450,200);
		// 点击关闭时，程序停止
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 流水布局，LEFT从左到右，垂直方向距离15、水平方向距离15
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		// 字体
		Font font = new Font("微软雅黑", Font.PLAIN, 18);
		
		// 文本输入框
		JTextField textField1 = new JTextField(5);
		textField1.setFont(font);
		this.add(textField1);
		
		// 标签1
		JLabel addLabel = new JLabel("+");
		addLabel.setFont(font);
		this.add(addLabel);
		
		// 文本输入框
		JTextField textField2 = new JTextField(5);
		textField2.setFont(font);
		this.add(textField2);
		
		// 标签 
		JLabel equalButton = new JLabel("=");
		equalButton.setFont(font);
		this.add(equalButton);
		
		// 和
		JLabel sumLabel = new JLabel("?");
		sumLabel.setFont(font);
		this.add(sumLabel);
		
		// 按钮
		JButton button = new JButton("calculate");
		button.setFont(font);
		button.addActionListener((evt) -> {
			try {
				Integer num1 = Integer.parseInt(textField1.getText());
				Integer num2 = Integer.parseInt(textField2.getText());
				sumLabel.setText(num1 + num2 + "");//后面+空串，变成字符串
			} catch (Exception e) {
				// 让弹框在窗口中间
				int w = 300;
				int h = 100;
				int x = this.getX() + (this.getWidth() - w) >> 1;
				int y = this.getY() + (this.getHeight() - h) >> 1;
				// modal设置为true：弹框后frame界面无法再操作，必须先处理弹框
				JDialog dialog = new JDialog(this,true) {{//双括号初始化
					this.setTitle("警告");
					this.setBounds(x, y, w, h);
					this.setResizable(false);//不能鼠标拖动大小
					
					JLabel label = new JLabel(" 请输入正确格式的数字!!!!");
					label.setFont(font);
					this.add(label);
				}};
				dialog.setVisible(true);
			}
			
		});
		this.add(button);
		
		JTextField tf3 = new JTextField(10);
		tf3.setFont(font);
		this.add(tf3);

		JTextField tf4 = new JTextField(10);
		tf4.setFont(font);
		this.add(tf4);
		
		JButton saveBtn = new JButton("保存");
		saveBtn.setFont(font);
		saveBtn.addActionListener((evt) -> {
			
		});
		this.add(saveBtn);
		
	}
	
}
