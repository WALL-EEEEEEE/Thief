import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Test3 {
	
	public static void main(String[] args) {
		
	   JFrame jf = new JFrame();
	   jf.setLayout(new FlowLayout(2));
	   JLabel jlname = new JLabel("�Ñ���:");
	   JLabel jlpwd  = new JLabel("����:");
	   JButton jblogin = new JButton();
	   JButton jbcancel = new JButton();
	   
	   //��ȡ��¼��ťͼƬ
	   Toolkit toolkit = Toolkit.getDefaultToolkit();
	   ImageIcon login_icon = new ImageIcon(toolkit.getImage("src/image/login.png"));
	   ImageIcon login_cancel = new ImageIcon(toolkit.getImage("src/image/dialog_cancel.png"));
       	 
 	   jblogin.setIcon(login_icon);
	   jbcancel.setIcon(login_cancel);
	   //���ֵ�¼��ť�ͳ�����ť�߶�һ��
	 
	  
	   jbcancel.setPreferredSize(new Dimension(70,30));
	   jblogin.setPreferredSize(new Dimension(70,30));
	   
	   JTextField jtfname = new JTextField(10);
	   JPasswordField jtfpwd = new JPasswordField(10);
	   jf.add(jlname);
	   jf.add(jtfname);
	   jf.add(jlpwd);
	   jf.add(jtfpwd);
	   jf.add(jblogin);
	   jf.add(jbcancel);
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.setBounds(200, 200, 300, 300);
       jf.setVisible(true);
	}

}
