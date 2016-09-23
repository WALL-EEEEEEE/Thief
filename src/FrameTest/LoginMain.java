package FrameTest;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginMain {
   
	public static void main(String[] args){
		System.out.println("Loading Application...");
		//创建一个窗体
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		
		final JFrame frame = new JFrame();
		
		frame.setLayout(flow);
		//设置标题
		frame.setTitle("登录窗口");
		//设置窗体的位置和大小
		frame.setBounds(200,200,300,350);
		//设置当前窗口关闭的时候，程序退出
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口为左对齐
	
		//获取工具套件
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//获取指定背景图片
		Image imgBg = toolkit.getImage("imgs/bg.jpg");
		//设置背景图片
		frame.setIconImage(imgBg);
		
		//获取指定窗口Icon图片
		final Image imgTitle = toolkit.getImage("imgs/title01.png");
		//窗体设置icon
		frame.setIconImage(imgTitle);
	     
		//创建一个Jlabel 显示图片
		JLabel labelBg = new JLabel(new ImageIcon(imgBg));
		 
		//用户名:
		JLabel lableName = new JLabel("用户名:");
		
		//用户名输入框
		final JTextField txtName = new JTextField(18);
		//密码
		JLabel labelPass = new JLabel("密     码:");
		//密码输入框
		final JPasswordField textPass = new JPasswordField(18);
		//设置密码框的回显字符
		textPass.setEchoChar('*');
		
		//登录按钮
		JButton buttonLogin = new JButton("登录");
		//设置登录按钮的Icon
		Image imgYes = toolkit.getImage("src/image/login.png");
		buttonLogin.setIcon(new ImageIcon(imgYes));
		
		//取消按钮
		JButton buttonCancel = new JButton("取消");
		final Image imgError = toolkit.getImage("src/image/dialog_cancel.png");
		buttonCancel.setIcon(new ImageIcon(imgError));
		
		FlowLayout flowLayout = new FlowLayout();
		//将Frame设置成流布局
		frame.setLayout(flowLayout);
           
		//将图片放入Frame
		frame.add(labelBg);
		
		//将用户名的Label和输入框放入Frame
		frame.add(lableName);
		frame.add(txtName);
		
		//将密码和密码框放入Frame
		frame.add(labelPass);
		frame.add(textPass);
		//将登录按钮和取消按钮放入Frame
		frame.add(buttonLogin);
		frame.add(buttonCancel);
		
		//给取消按钮注册事件监听
		buttonCancel.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtName.setText("");
				textPass.setText("");
			}
		});
		
		//给登录按钮注册事件监听
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//获取输入的用户名和密码
				String name = txtName.getText();
				char[] cs   = textPass.getPassword();
				String pass = new String(cs);
				
				//如果用户名和密码没有填写，则给予提示
				if (name == null || name.equals("")){
					JOptionPane.showMessageDialog(frame, "用户名不能为空");
					return ;
				}
				if ( pass == null || pass.equals("")) {
					JOptionPane.showMessageDialog(frame,"用户密码不能为空");
					return ;
				}
				
				
				if (name.equals("张三")&& pass.equals("123") || name.equals("李四") && pass.equals("245")){
					System.out.println("登录成功");
					//将当前页面设置成不可见
					frame.setVisible(false);
					frame.dispose();
					//打开主页面
					new MainFrame();
				}else {
					System.out.println("登录失败");
					JOptionPane.showMessageDialog(frame, "用户名或密码错误");
				}
				
				//设置当前窗体的可见性
				
			}
		});
		
		
		frame.setVisible(true);
		
	}
}
