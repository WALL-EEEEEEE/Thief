package FrameTest2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableSample extends JPanel {
    private boolean DEBUG = false;
    
    
    public JTableSample() {
	// TODO Auto-generated constructor stub
     super(new GridLayout(1,0));
     String[] columnsNames = {"First Name",
    		 "Last Name",
    		 "Sport",
    		 "# of Years",
    		 "Vegetarian"
     };
     
     Object[][] data = {
    		 {"Kathy","Smith","Snowboarding",new Integer(5), new Boolean(false)},
    		 {"John","Doe","Rowing",new Integer(3),new Boolean(true)},
    		 {"Sue","Black","Knitting",new Integer(2),new Boolean(true)},
    		 {"Jane","White","Speed reading",new Integer(20),new Boolean(true)}
    		 };
     final JTable table = new JTable(data,columnsNames);
     table.setPreferredScrollableViewportSize(new Dimension(500,70));
     table.setFillsViewportHeight(true);
     
     if(DEBUG) {
    	 table.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e){
			   printDebugData(table);
		   }
    	 });
     }
     //Create the scroll pane and add the table to it.
     JScrollPane scrollPane = new JScrollPane(table);
     //Add the scroll pane to this panel.
     add(scrollPane);
    }
    
    private void printDebugData(JTable table){
    	int numRows = table.getRowCount();
    	int numCols = table.getColumnCount();
    	javax.swing.table.TableModel model = table.getModel();
    	
    	System.out.println("Value of data:");
    	
    	for(int i = 0; i< numRows;i++){
    		System.out.print("    row"+i+":");
    		for( int j=0; j < numCols; j++){
    			System.out.print("  "+model.getValueAt(i, j));
    		}
    		System.out.println();
    	}
    	System.out.println("-----------------------");
    }
    
    private static void createAndShowGUI(){
    	//Create and set up the window.
    	JFrame frame = new JFrame("JTableSample");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//Create and set up the content pane.
    	JTableSample newContentPane = new JTableSample();
    	newContentPane.setOpaque(true);//content panes must be opaque
    	frame.setContentPane(newContentPane);
    	
    	//Display the window
    	frame.pack();
    	frame.setVisible(true);
    }
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			  createAndShowGUI();	
			}
		});
	}
}
