package FrameTest2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;




public class MainFrame  extends JFrame{
	JPanel panelLeft;
	JPanel panelRight;
	
	private String passOldStr;
    private String name;
    private String pass;
	

	
	public MainFrame(String name,String pass) {
		// TODO Auto-generated constructor stub
	    this.name = name;
	    this.pass = pass;
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
			
			//添加账号相关
			DefaultMutableTreeNode node03 = new DefaultMutableTreeNode("账号相关");
			node03.add(new DefaultMutableTreeNode("修改密码"));
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有操作");
			root.add(node01);
			root.add(node02);
			root.add(node03);
			
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
							
							addEmp();
//							panelRight.validate();
						
						}else if(str.equals("修改密码")){
							modifyPassword();
						}else if (str.equals("查询")){
							queryEmp();
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
			JLabel labelTest1 = new JLabel("");
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
					Employer employer = new Employer(name,gender,dept);
					Boolean Issaved = saveEmp(employer);
				
					
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
		
		public void modifyPassword(){
			//先删除Panel中之前的内容
			panelRight.removeAll();
			panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel labeloldPass = new JLabel("  原密码");
			JLabel labelNewPass01 = new JLabel("  新密码");
			JLabel labelNewPass02 = new JLabel("重复密码:");
			
			final JPasswordField passold = new JPasswordField(14);
			final JPasswordField passNew01 = new JPasswordField(14);
			final JPasswordField passNew02 = new JPasswordField(14);
			
			JButton butModify = new JButton("修改密码");
			
			panelRight.add(labeloldPass);
			panelRight.add(passold);
			panelRight.add(labelNewPass01);
			panelRight.add(passNew01);
			panelRight.add(labelNewPass02);
			panelRight.add(passNew02);
			panelRight.add(butModify);
			
			passold.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent arg0) {
					// TODO Auto-generated method stub
					//获取该文本框中的值
					char[] cs = passold.getPassword();
				    passOldStr = new String(cs); 
				    if(!pass.equals(passOldStr)){
				    	JOptionPane.showMessageDialog(MainFrame.this,"原密码有误!");
				    	passold.requestFocus();
				    	passold.selectAll();
				    }
				}
				
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			
			});
			
			butModify.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//获取新密码
					char[] cs01 = passNew01.getPassword();
					char[] cs02 = passNew02.getPassword();
					String p01 = new String(cs01);
					String p02 = new String(cs02);
					if(!p01.equals(p02)){
						JOptionPane.showMessageDialog(MainFrame.this,"两次密码不一致" );
					}else{
						//修改密码
						try{
							System.out.println(name+"   "+p02);
							
							boolean flag = UserManager.modifyPass(name, p02);
						    
							if(flag){
								JOptionPane.showMessageDialog(MainFrame.this,"密码修改成功");
								
							}else{
								JOptionPane.showMessageDialog(MainFrame.this, "密码修改失败");
								
							}
						} catch (ClassNotFoundException e){
							e.printStackTrace();
						}
						
					}
				}
			});
			
			panelRight.updateUI();
			
			
		}
		public boolean saveEmp(Employer emplyer){
			Connection conn = null;
			try {
			 conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			 PreparedStatement pre = (PreparedStatement) conn.prepareStatement("Insert into test.staffs(emp_name,emp_gender,emp_dept) values(?,?,?)");
			 pre.setString(1, emplyer.getName());
			 pre.setString(2, emplyer.getGender());
			 pre.setString(3, emplyer.getDept());
			 System.out.println(emplyer.getGender());
			 Boolean result =  pre.execute();
			 return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 return false;
			
		
			
			
		}
		
		
		public void queryEmp(){
			//清除所有内容
			panelRight.removeAll();
			//获取员工数据
            ArrayList<Employer> emps = getAllEmp();
            //设置表头信息
           //生成对应数组
            int size = emps.size();
            Object[][] a_emps = new Object[size][];
            
            for(int i =0; i<size;i++){
            	String ConvertGender = new Integer(emps.get(i).getGender()) == 0 ?"女":"男";
            	a_emps[i] =new String[]{emps.get(i).getName(),emps.get(i).getDept(),ConvertGender};
            }
            
            
            String[] table_title = {"姓名","部门","性别"};
	        Iterator<Employer> its = emps.iterator();
	        JTable staffTable = new JTable(a_emps,table_title);
	        panelRight.add(staffTable);
	        panelRight.updateUI();
            
		}
		
		public ArrayList<Employer> getAllEmp(){
			
		
			
			Connection conn = null;
	        ArrayList<Employer> emps = new ArrayList<Employer>();
			try {
			 conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			 PreparedStatement pre = (PreparedStatement) conn.prepareStatement("select * from test.staffs");
			 ResultSet results = pre.executeQuery();
			 
			 //将结果集放入到数组中
			 while(results.next()){
				 Employer emp = new Employer();
			
				 emp.setDept(results.getString("emp_dept"));
				 emp.setGender(new Integer(results.getString("emp_gender")));
				 emp.setName(results.getString("emp_name"));
				 emps.add(emp);
			 }
			
			  return emps;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ArrayList<Employer>();

		}	
	
	

}
