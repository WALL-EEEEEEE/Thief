package FrameTest2;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class TestMain {
   
	static JFrame frame;
	static JTextField txtName;
	static JPasswordField txtPass;
	 
	public static void main(String[] args) {
	   //创建窗体
		createFrame();
	}
	
	//创建窗体
	private static void createFrame() {
		// TODO Auto-generated method stub
         frame = new JFrame();
         frame.setTitle("登录");
         frame.setBounds(200, 200, 300, 350);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         //在窗体中添加图片
         addImg();
         //添加用户名和密码
         addUserInfo();
         frame.setVisible(true);
	}
	
	//获取指定位置的图片
	public static Image getImage(String imgPath){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage(imgPath);
		return img;
	}
	
	public static void addImg(){
		Image img = getImage("imgs/bg.jpg");
		JLabel label = new JLabel(new ImageIcon(img));
		frame.add(label);
	}
	
	//在窗体中添加用户名和密码
	public static void addUserInfo(){
		JLabel labelName = new JLabel("用户名：");
		JLabel labelPass = new JLabel("密码: ");
		txtName = new JTextField(18);
		txtPass = new JPasswordField(18);
		txtName.addFocusListener(new FocusListener() {
	    		
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			    String name = txtName.getText();
			    //判断用户名和密码的输入框是否为空
			    if (name == null || name.equals("")){
			    	JOptionPane.showMessageDialog(frame, "用户名不能为空");
			    	txtName.requestFocus();
			    	return ;
			    }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtName.selectAll();
			}
		});
		
		Image imgLogin = getImage("image/login.png");
		Image imageCancel = getImage("image/dialog_cancel.png");
		JButton buttonLogin = new JButton("登录",new ImageIcon(imgLogin));
		JButton buttonCancel = new JButton("取消", new ImageIcon(imageCancel));
		
	
		
		
	
		
		//给登录按钮添加事件监听
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//输入框中的值
				String name = txtName.getText();
				char[] cs = txtPass.getPassword();
				String pass = new String(cs);
				
				if(name == null || name.equals("")){
					JOptionPane.showMessageDialog(frame, "用户名不能为空");
					txtName.requestFocus();
					return;
				}
				if (pass == null || pass.equals("")){
					JOptionPane.showMessageDialog(frame, "密码不能为空");
					txtPass.requestFocus();
					return ;
					
				}
				
				//获取数据库的连接
				try {
					
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				    PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select uname,upwd from user where uname=? and upwd = ?");
				    ps.setString(1, name);
				    ps.setString(2,pass);
				    //执行SQL语句
				    ResultSet rs = ps.executeQuery();
				    if(rs.next()){
				    	//先关闭当前窗口
				    	frame.dispose();
				    	//打开新的窗口
				    	new MainFrame();
				    	
				    }else{
				    	JOptionPane.showMessageDialog(frame, "用户名和密码错误");
				    	//用户名的输入框获取焦点
				    	txtName.selectAll();
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			/*	if(name.equals("张三") && pass.equals("123")){
					//先关闭当前窗口
					frame.dispose();
					//打开新的窗口
					new MainFrame();
				}*/
			}
		});
		
		
		frame.add(labelName);
		frame.add(txtName);
		frame.add(labelPass);
		frame.add(txtPass);
		frame.add(buttonLogin);
		frame.add(buttonCancel);
	}
	
}
