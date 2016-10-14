package FrameTest2;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import FrameTest2.MainFrame;

public class TestMain {
   
    static JFrame frame;
    static JTextField txtName;
    static JPasswordField txtPass;
     
    public static void main(String[] args) {
        createFrame();
    }
    
    private static void createFrame() {
         // TODO Auto-generated method stub
         frame = new JFrame();
         frame.setTitle("登录");
         frame.setBounds(200, 200, 300, 350);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new BoxLayout(frame.getContentPanel(),Box));
         frame.setLayout(new FlowLayout());
         
         addImg();
         addUserInfo();
         frame.setVisible(true);
    }
    
    public static Image getImage(String imgPath){
         Toolkit toolkit = Toolkit.getDefaultToolkit();
         Image img = toolkit.getImage(imgPath);
         return img;
    }
    
    public static void addImg(){
        Image img = getImage("imgs/bg.jpg");
        JLabel label = new JLabel(new ImageIcon(img));
        label.setSize(20, 20);
        frame.add(label);
    }
   

	//添加用户信息
	public static void addUserInfo(){
		JLabel labelName = new JLabel("姓名:");
		JLabel labelPass = new JLabel("密码: ");
		txtName = new JTextField(18);
		txtPass = new JPasswordField(18);
		txtName.addFocusListener(new FocusListener() {
	    		
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			    String name = txtName.getText();
			    if (name == null || name.equals("")){
			    	JOptionPane.showMessageDialog(frame, "用户名字不能为空");
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
		
	
		
		
	
		
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = txtName.getText();
				char[] cs = txtPass.getPassword();
				String pass = new String(cs);
				
				if(name == null || name.equals("")){
					JOptionPane.showMessageDialog(frame, "用户名不能为空");
					txtName.requestFocus();
					return;
				}
				if (pass == null || pass.equals("")){
					JOptionPane.showMessageDialog(frame, "用户密码不能为空");
					txtPass.requestFocus();
					return ;
					
				}
				
                /**
                 * 捕捉异常
                 */
				try {
					
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                    
                    
                    
            
                    
            
				    PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select uname,upwd from employer where uname=? and upwd = ?");
                
                    
				    ps.setString(1, name);
				    ps.setString(2,pass);
				    ResultSet rs = ps.executeQuery();
				    if(rs.next()){
				    	frame.dispose();
				    	//打开新的界面
				    	new MainFrame(name,pass);
				    	
				    }else{
				    	JOptionPane.showMessageDialog(frame, "用户名或者密码不正确");
				    	txtName.selectAll();
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			/*	if(name.equals("张三") && pass.equals("123")){
					frame.dispose();
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
