package FrameTest2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;




public class MainFrame  extends JFrame{
	JPanel panelLeft;
	JPanel panelRight;

	
	public static void main(String[] args){
		new MainFrame();
	}
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
	     createFrame();
	}
	
	
	//创建窗体
	public void createFrame(){
		this.setTitle("主页面");
		this.setBounds(200, 200, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		addMenuBar();
		//添加左边的面板
		initLeft();
		//添加右边的面板
		initRight();
		
		this.setVisible(true);
		
		
	}
	
	//在当前窗口添加菜单
	public void addMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("文件");
		Image imgNew = TestMain.getImage("imgs/png");
		
		JMenuItem itemNew = new JMenuItem("新建",new ImageIcon(imgNew));
		JMenuItem itemSave =  new JMenuItem("保存");
		JMenuItem itemExit = new JMenuItem("退出");
		menuFile.add(itemNew);
		menuFile.add(itemSave);
		menuFile.add(menuFile);
		
		menuBar.add(menuFile);
		itemNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("aaaa");
				
			}
		});
	}
		
		//当前窗口的左边田间JPanel
		
		public void initLeft(){
			panelLeft = new JPanel();
			//设置左对齐
			panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
			//设置Jpanel的宽度
			panelLeft.setPreferredSize(new Dimension(150, 100));
			
			//将属性菜单放入panel中
			initTree();
			this.add(panelLeft,BorderLayout.WEST);
		}
		
		//在当前矿口的中间部分添加panel
		public void initRight(){
			panelRight = new JPanel();
			panelRight.setBackground(Color.ORANGE);
		    //设置Jpanel的宽度
			this.add(panelRight,BorderLayout.CENTER);
			
		}
		
		//初始化JTree
		public void initTree(){
			DefaultMutableTreeNode node01 = new DefaultMutableTreeNode("员工管理");
			node01.add(new DefaultMutableTreeNode("新增"));
			node01.add(new DefaultMutableTreeNode("查询"));
			node01.add(new DefaultMutableTreeNode("修改"));
			
			DefaultMutableTreeNode node02 = new DefaultMutableTreeNode("部门管理");
			node02.add(new DefaultMutableTreeNode("新增部门"));
			node02.add(new DefaultMutableTreeNode("查询所有部门"));
			node02.add(new DefaultMutableTreeNode("修改"));
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有操作");
			root.add(node01);
			root.add(node02);
			
			final JTree tree = new JTree(root);
			//设置tree背景透明
			tree.setOpaque(false);
			//将节点中的背景色设置为透明
			DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
			cellRenderer.setBackgroundNonSelectionColor(new Color(0,0,0,0));
			cellRenderer.setBackground(new Color(0,0,0,0));
			tree.setCellRenderer(cellRenderer);
			panelLeft.add(tree);
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				
				@Override
				public void valueChanged(TreeSelectionEvent arg0) {
					// TODO Auto-generated method stub
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(node.isLeaf()){
					//	System.out.println(node.getUserObject());
						String str= (String) node.getUserObject();
						
						if (str.equals("新增")){
							System.out.println(str);
							addEmp();
//							panelRight.validate();
							
						
						}
					}
					
				}
			});
			
			
			
			
		}
		
		//新增员工页面
		public void addEmp(){
//			Panel test = new Panel();
//			panelRight.setLayout(new BorderLayout());
//			panelRight.add(test);
			
			//先删除Panel中之前的内容
			System.out.println("addEmp");
			panelRight.removeAll();
			panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel lableName = new JLabel("姓    名:");
			final JTextField txtName = new JTextField(16);
			JLabel lableGender = new JLabel("                     性    别:");
			JRadioButton male = new JRadioButton("男");
			male.setOpaque(false);
			final JRadioButton female = new JRadioButton("女");
			female.setOpaque(false);
			
			ButtonGroup group = new ButtonGroup();
			group.add(male);
			group.add(female);
			
			JLabel labelTest = new JLabel("                ");
			
			JLabel labelDept = new JLabel("                        部   门:");
			String[] items = {"开发部", "市场部","行政部"};
			final JComboBox<String> boxDept = new JComboBox<String>(items);
			JLabel labelTest1 = new JLabel("22222222222222");
			JButton butAdd = new JButton("添加");
			
			panelRight.add(lableName);
			panelRight.add(txtName);
			panelRight.add(lableGender);
			panelRight.add(male);
			panelRight.add(female);
			panelRight.add(labelDept);
			panelRight.add(boxDept);
			panelRight.add(labelTest1);
			panelRight.add(butAdd);
			
			System.out.println("panelRight");
			
			butAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String name = txtName.getText();
					int gender = 1;
					if(female.isSelected()){
						gender = 0;	
					}
					String dept = (String) boxDept.getSelectedItem();
					//添加员工信息进入数据库
					Emplyer emplyer = new Emplyer(name,gender,dept);
					Boolean Issaved = saveEmp(emplyer);
					
					if (Issaved){
						JOptionPane.showMessageDialog(MainFrame.this,"保存失败");
					}else{
						JOptionPane.showMessageDialog(MainFrame.this,"保存成功");
					}
				}
			});
			
			panelRight.repaint();
			panelRight.updateUI();
			
		}
		
		public boolean saveEmp(Emplyer emplyer){
			Connection conn = null;
			try {
			 conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			 PreparedStatement pre = (PreparedStatement) conn.prepareStatement("Insert into test.employee(emp_name,emp_gender,emp_dept) values(?,?,?)");
			 pre.setString(1, emplyer.getName());
			 pre.setInt(2, emplyer.getGender());
			 pre.setString(3, emplyer.getDept());
			 
			 Boolean result =  pre.execute();
			 return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 return false;
			
		
			
			
		}
		
	
	

}
