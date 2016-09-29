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
				System.out.println("aaaa");
				
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
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("���в���");
			root.add(node01);
			root.add(node02);
			
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
							System.out.println(str);
							addEmp();
//							panelRight.validate();
							
						
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
			System.out.println("addEmp");
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
			JLabel labelTest1 = new JLabel("22222222222222");
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
					//���Ա����Ϣ�������ݿ�
					Emplyer emplyer = new Emplyer(name,gender,dept);
					Boolean Issaved = saveEmp(emplyer);
					
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
