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
	
	
	//��������
	public void createFrame(){
		this.setTitle("��ҳ��");
		this.setBounds(200, 200, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		addMenuBar();
		//�����ߵ����
		initLeft();
		//����ұߵ����
		initRight();
		
		this.setVisible(true);
		
		
	}
	
	//�ڵ�ǰ������Ӳ˵�
	public void addMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("�ļ�");
		Image imgNew = TestMain.getImage("imgs/png");
		
		JMenuItem itemNew = new JMenuItem("�½�",new ImageIcon(imgNew));
		JMenuItem itemSave =  new JMenuItem("����");
		JMenuItem itemExit = new JMenuItem("�˳�");
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
		
		//��ǰ���ڵ�������JPanel
		
		public void initLeft(){
			panelLeft = new JPanel();
			//���������
			panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
			//����Jpanel�Ŀ��
			panelLeft.setPreferredSize(new Dimension(150, 100));
			
			//�����Բ˵�����panel��
			initTree();
			this.add(panelLeft,BorderLayout.WEST);
		}
		
		//�ڵ�ǰ��ڵ��м䲿�����panel
		public void initRight(){
			panelRight = new JPanel();
			panelRight.setBackground(Color.ORANGE);
		    //����Jpanel�Ŀ��
			this.add(panelRight,BorderLayout.CENTER);
			
		}
		
		//��ʼ��JTree
		public void initTree(){
			DefaultMutableTreeNode node01 = new DefaultMutableTreeNode("Ա������");
			node01.add(new DefaultMutableTreeNode("����"));
			node01.add(new DefaultMutableTreeNode("��ѯ"));
			node01.add(new DefaultMutableTreeNode("�޸�"));
			
			DefaultMutableTreeNode node02 = new DefaultMutableTreeNode("���Ź���");
			node02.add(new DefaultMutableTreeNode("��������"));
			node02.add(new DefaultMutableTreeNode("��ѯ���в���"));
			node02.add(new DefaultMutableTreeNode("�޸�"));
			
			//����˺����
			DefaultMutableTreeNode node03 = new DefaultMutableTreeNode("�˺����");
			node03.add(new DefaultMutableTreeNode("�޸�����"));
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("���в���");
			root.add(node01);
			root.add(node02);
			root.add(node03);
			
			final JTree tree = new JTree(root);
			//����tree����͸��
			tree.setOpaque(false);
			//���ڵ��еı���ɫ����Ϊ͸��
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
						
						if (str.equals("����")){
							
							addEmp();
//							panelRight.validate();
						
						}else if(str.equals("�޸�����")){
							modifyPassword();
						}else if (str.equals("��ѯ")){
							queryEmp();
						}
					}
					
				}
			});
			
			
			
			
		}
		
		//����Ա��ҳ��
		public void addEmp(){
//			Panel test = new Panel();
//			panelRight.setLayout(new BorderLayout());
//			panelRight.add(test);
			
			//��ɾ��Panel��֮ǰ������
	
			panelRight.removeAll();
			panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel lableName = new JLabel("��    ��:");
			final JTextField txtName = new JTextField(16);
			JLabel lableGender = new JLabel("                     ��    ��:");
			JRadioButton male = new JRadioButton("��");
			male.setOpaque(false);
			final JRadioButton female = new JRadioButton("Ů");
			female.setOpaque(false);
			
			ButtonGroup group = new ButtonGroup();
			group.add(male);
			group.add(female);
			
			JLabel labelTest = new JLabel("                ");
			
			JLabel labelDept = new JLabel("                        ��   ��:");
			String[] items = {"������", "�г���","������"};
			final JComboBox<String> boxDept = new JComboBox<String>(items);
			JLabel labelTest1 = new JLabel("");
			JButton butAdd = new JButton("���");
			
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
					//���Ա����Ϣ�������ݿ�
					Employer employer = new Employer(name,gender,dept);
					Boolean Issaved = saveEmp(employer);
				
					
					if (Issaved){
						JOptionPane.showMessageDialog(MainFrame.this,"����ʧ��");
					}else{
						JOptionPane.showMessageDialog(MainFrame.this,"����ɹ�");
					}
				}
			});
			
			panelRight.repaint();
			panelRight.updateUI();
			
		}
		
		public void modifyPassword(){
			//��ɾ��Panel��֮ǰ������
			panelRight.removeAll();
			panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel labeloldPass = new JLabel("  ԭ����");
			JLabel labelNewPass01 = new JLabel("  ������");
			JLabel labelNewPass02 = new JLabel("�ظ�����:");
			
			final JPasswordField passold = new JPasswordField(14);
			final JPasswordField passNew01 = new JPasswordField(14);
			final JPasswordField passNew02 = new JPasswordField(14);
			
			JButton butModify = new JButton("�޸�����");
			
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
					//��ȡ���ı����е�ֵ
					char[] cs = passold.getPassword();
				    passOldStr = new String(cs); 
				    if(!pass.equals(passOldStr)){
				    	JOptionPane.showMessageDialog(MainFrame.this,"ԭ��������!");
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
					//��ȡ������
					char[] cs01 = passNew01.getPassword();
					char[] cs02 = passNew02.getPassword();
					String p01 = new String(cs01);
					String p02 = new String(cs02);
					if(!p01.equals(p02)){
						JOptionPane.showMessageDialog(MainFrame.this,"�������벻һ��" );
					}else{
						//�޸�����
						try{
							System.out.println(name+"   "+p02);
							
							boolean flag = UserManager.modifyPass(name, p02);
						    
							if(flag){
								JOptionPane.showMessageDialog(MainFrame.this,"�����޸ĳɹ�");
								
							}else{
								JOptionPane.showMessageDialog(MainFrame.this, "�����޸�ʧ��");
								
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
			//�����������
			panelRight.removeAll();
			//��ȡԱ������
            ArrayList<Employer> emps = getAllEmp();
            //���ñ�ͷ��Ϣ
           //���ɶ�Ӧ����
            int size = emps.size();
            Object[][] a_emps = new Object[size][];
            
            for(int i =0; i<size;i++){
            	String ConvertGender = new Integer(emps.get(i).getGender()) == 0 ?"Ů":"��";
            	a_emps[i] =new String[]{emps.get(i).getName(),emps.get(i).getDept(),ConvertGender};
            }
            
            
            String[] table_title = {"����","����","�Ա�"};
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
			 
			 //����������뵽������
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
