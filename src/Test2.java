import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Test2 {
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		JButton jb01 = new JButton();
		//创建一个标签
		final JLabel label = new JLabel();
		//创建输入框
		final JTextField jtf01 = new JTextField(10);
		
		jf.setLayout(new FlowLayout());
		jf.setBounds(200, 200, 300, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		ImageIcon icon = new ImageIcon(tk.getImage("src/hell.png"));
		
		jb01.setIcon(icon);
		jf.add(jb01);
		jf.add(label);
		jf.add(jtf01);
		
		jb01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = jtf01.getText();
				System.out.println("Hello,"+name);
				//给标签设置显示的文本
				label.setText("Hello,"+name);
			}
		});
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
