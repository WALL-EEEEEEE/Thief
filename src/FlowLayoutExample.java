

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {
	
public static void main(String args[]){
		
		FlowLayoutDemo window = new FlowLayoutDemo();
		window.setTitle("流式布局");
		//该代码依据依据放置的组件设定窗口的大小正好容纳你放置的所有组建
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	}

}


class FlowLayoutDemo extends JFrame{
	public FlowLayoutDemo(){
		//设置窗体为流式布局,无参数默认为居中对齐
		setLayout(new FlowLayout());
		//设置窗体中显示的字体样式
		setFont(new Font("Helvetica",Font.PLAIN,14));
		//将按钮添加窗体中
		getContentPane().add(new JButton("Button 1"));
		getContentPane().add(new JButton("Button 2"));
		getContentPane().add(new JButton("Button 3"));
		getContentPane().add(new JButton("Button 4"));
		
		
	}
	
	
}