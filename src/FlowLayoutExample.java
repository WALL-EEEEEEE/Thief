

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {
	
public static void main(String args[]){
		
		FlowLayoutDemo window = new FlowLayoutDemo();
		window.setTitle("��ʽ����");
		//�ô����������ݷ��õ�����趨���ڵĴ�С������������õ������齨
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	}

}


class FlowLayoutDemo extends JFrame{
	public FlowLayoutDemo(){
		//���ô���Ϊ��ʽ����,�޲���Ĭ��Ϊ���ж���
		setLayout(new FlowLayout());
		//���ô�������ʾ��������ʽ
		setFont(new Font("Helvetica",Font.PLAIN,14));
		//����ť��Ӵ�����
		getContentPane().add(new JButton("Button 1"));
		getContentPane().add(new JButton("Button 2"));
		getContentPane().add(new JButton("Button 3"));
		getContentPane().add(new JButton("Button 4"));
		
		
	}
	
	
}