import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class MainFrame  extends JFrame{
	JPanel panelLeft;
	JPanel panelRight;
	
	
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
			
			JTree tree = new JTree(root);
			//����tree����͸��
			tree.setOpaque(false);
			//���ڵ��еı���ɫ����Ϊ͸��
			DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
			cellRenderer.setBackgroundNonSelectionColor(new Color(0,0,0,0));
			cellRenderer.setBackground(new Color(0,0,0,0));
			tree.setCellRenderer(cellRenderer);
			panelLeft.add(tree);
			
			
		}
		
		
	
	

}
