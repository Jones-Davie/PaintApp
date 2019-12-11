import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Paint {
	
	//make a window for the app
	JFrame frame;
	
	//init an array to hold the locations and sizes of the painted things
	ArrayList<Integer> ovals = new ArrayList<Integer>();
	
	//make variables to check how many of each have been created
	long paintedOvals = 0;
	
	//check if the user has mousedown
	boolean mousedown = false;
	
	//make an initialisation method
	public void go () {
	 
	 //init frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(880, 600);
		frame.setVisible(true);
		
		//init a pannel to hold to color buttons
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout ( colorPanel, BoxLayout.Y_AXIS) );
		colorPanel.setBackground(Color.gray);
		
		//make a menu from the menu class and initialise it with go();
		Menu menu = new Menu();
		menu.go();
				
		for ( JButton button : menu.colorButtons ) {
			
			colorPanel.add(button);
			System.out.println("added " + button.getName());
		}
		
		//add the pannel to the west side of the frame
		frame.getContentPane().add(BorderLayout.WEST, colorPanel);
		
	}
	
	//make a class that paints the ovals on the frame
	class MyDrawPannel extends JPanel {
		
		public void paintComponent (Graphics g) {
			
			//make a variable for the 2d paint function
			Graphics2D g2d = (Graphics2D) g;
			
		}
		
	}
	
}