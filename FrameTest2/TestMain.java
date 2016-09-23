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
	   //��������
		createFrame();
	}
	
	//��������
	private static void createFrame() {
		// TODO Auto-generated method stub
         frame = new JFrame();
         frame.setTitle("��¼");
         frame.setBounds(200, 200, 300, 350);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         //�ڴ��������ͼƬ
         addImg();
         //����û���������
         addUserInfo();
         frame.setVisible(true);
	}
	
	//��ȡָ��λ�õ�ͼƬ
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
	
	//�ڴ���������û���������
	public static void addUserInfo(){
		JLabel labelName = new JLabel("�û�����");
		JLabel labelPass = new JLabel("����: ");
		txtName = new JTextField(18);
		txtPass = new JPasswordField(18);
		txtName.addFocusListener(new FocusListener() {
	    		
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			    String name = txtName.getText();
			    //�ж��û����������������Ƿ�Ϊ��
			    if (name == null || name.equals("")){
			    	JOptionPane.showMessageDialog(frame, "�û�������Ϊ��");
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
		JButton buttonLogin = new JButton("��¼",new ImageIcon(imgLogin));
		JButton buttonCancel = new JButton("ȡ��", new ImageIcon(imageCancel));
		
	
		
		
		
		//����¼��ť����¼�����
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//������е�ֵ
				String name = txtName.getText();
				char[] cs = txtPass.getPassword();
				String pass = new String(cs);
				if(name == null || name.equals("")){
					JOptionPane.showMessageDialog(frame, "�û�������Ϊ��");
					txtName.requestFocus();
					return;
				}
				
				if (pass == null || pass.equals("")){
					JOptionPane.showMessageDialog(frame, "���벻��Ϊ��");
					txtPass.requestFocus();
					return ;
					
				}
				
				if(name.equals("����") && pass.equals("123")){
					//�ȹرյ�ǰ����
					frame.dispose();
					//���µĴ���
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
