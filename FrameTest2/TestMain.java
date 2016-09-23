import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


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
				
				if(name.equals("张三") && pass.equals("123")){
					//先关闭当前窗口
					frame.dispose();
					//打开新的窗口
					new MainFrame();
				}
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
