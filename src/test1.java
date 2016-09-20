import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class test1 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//设置标题
		frame.setTitle("登录窗口");
		frame.setBounds(200, 200, 300, 300);
		
		Toolkit tookit = Toolkit.getDefaultToolkit();
		Image icon = tookit.getImage("src/hell.png");
		frame.setIconImage(icon);
		
		//将当前窗体设置成流布局
		frame.setLayout(new FlowLayout());
		//创建一个按钮
		JButton jb01 = new JButton("西");
		jb01.setIcon(new ImageIcon(tookit.getImage("src/hell.png")));
		frame.add(jb01);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	

}
}
