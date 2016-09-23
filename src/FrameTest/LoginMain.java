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
		//����һ������
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		
		final JFrame frame = new JFrame();
		
		frame.setLayout(flow);
		//���ñ���
		frame.setTitle("��¼����");
		//���ô����λ�úʹ�С
		frame.setBounds(200,200,300,350);
		//���õ�ǰ���ڹرյ�ʱ�򣬳����˳�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô���Ϊ�����
	
		//��ȡ�����׼�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//��ȡָ������ͼƬ
		Image imgBg = toolkit.getImage("imgs/bg.jpg");
		//���ñ���ͼƬ
		frame.setIconImage(imgBg);
		
		//��ȡָ������IconͼƬ
		final Image imgTitle = toolkit.getImage("imgs/title01.png");
		//��������icon
		frame.setIconImage(imgTitle);
	     
		//����һ��Jlabel ��ʾͼƬ
		JLabel labelBg = new JLabel(new ImageIcon(imgBg));
		 
		//�û���:
		JLabel lableName = new JLabel("�û���:");
		
		//�û��������
		final JTextField txtName = new JTextField(18);
		//����
		JLabel labelPass = new JLabel("��     ��:");
		//���������
		final JPasswordField textPass = new JPasswordField(18);
		//���������Ļ����ַ�
		textPass.setEchoChar('*');
		
		//��¼��ť
		JButton buttonLogin = new JButton("��¼");
		//���õ�¼��ť��Icon
		Image imgYes = toolkit.getImage("src/image/login.png");
		buttonLogin.setIcon(new ImageIcon(imgYes));
		
		//ȡ����ť
		JButton buttonCancel = new JButton("ȡ��");
		final Image imgError = toolkit.getImage("src/image/dialog_cancel.png");
		buttonCancel.setIcon(new ImageIcon(imgError));
		
		FlowLayout flowLayout = new FlowLayout();
		//��Frame���ó�������
		frame.setLayout(flowLayout);
           
		//��ͼƬ����Frame
		frame.add(labelBg);
		
		//���û�����Label����������Frame
		frame.add(lableName);
		frame.add(txtName);
		
		//���������������Frame
		frame.add(labelPass);
		frame.add(textPass);
		//����¼��ť��ȡ����ť����Frame
		frame.add(buttonLogin);
		frame.add(buttonCancel);
		
		//��ȡ����ťע���¼�����
		buttonCancel.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtName.setText("");
				textPass.setText("");
			}
		});
		
		//����¼��ťע���¼�����
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ������û���������
				String name = txtName.getText();
				char[] cs   = textPass.getPassword();
				String pass = new String(cs);
				
				//����û���������û����д���������ʾ
				if (name == null || name.equals("")){
					JOptionPane.showMessageDialog(frame, "�û�������Ϊ��");
					return ;
				}
				if ( pass == null || pass.equals("")) {
					JOptionPane.showMessageDialog(frame,"�û����벻��Ϊ��");
					return ;
				}
				
				
				if (name.equals("����")&& pass.equals("123") || name.equals("����") && pass.equals("245")){
					System.out.println("��¼�ɹ�");
					//����ǰҳ�����óɲ��ɼ�
					frame.setVisible(false);
					frame.dispose();
					//����ҳ��
					new MainFrame();
				}else {
					System.out.println("��¼ʧ��");
					JOptionPane.showMessageDialog(frame, "�û������������");
				}
				
				//���õ�ǰ����Ŀɼ���
				
			}
		});
		
		
		frame.setVisible(true);
		
	}
}
