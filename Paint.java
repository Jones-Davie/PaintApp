import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Paint {
	
	//make a window for the app
	JFrame frame;
	JMenuBar menuBar;
	JMenu colorMenu;
	JPanel colorPanel;
	
	
	private int width;
	private int heigth;
	
	//init an array to hold the locations and sizes of the painted things
	ArrayList<Integer> ovals = new ArrayList<Integer>();
	
	//make variables to check how many of each have been created
	long paintedOvals = 0;
	
	//check if the user has mousedown
	boolean mousedown = false;
	
	//make an initialisation method
	public void go () {
	 
		initFrame( width, heigth );
		initMenuBar();
		initColorPanel();

	}
	
	//make a class that paints the ovals on the frame
	class MyDrawPannel extends JPanel {
		
		public void paintComponent (Graphics g) {
			
			//make a variable for the 2d paint function
			Graphics2D g2d = (Graphics2D) g;
			
		}
	}
	
	//init frame
	private void initFrame ( int w, int h ) {
		
		frame = new JFrame("DrawApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		if ( h == 0 || w == 0) {
			frame.setSize(860, 600);
			
		} else {
			frame.setSize( (w + 60), h);
		}
	} // end init frame
	
	//init menuBar
	private void initMenuBar() {
		
		menuBar = new JMenuBar();
		
		//make file items
		JMenu fileMenu = new JMenu("file");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem loadFile = new JMenuItem("Load file");
		JMenuItem saveFile = new JMenuItem("Save File");
		fileMenu.add(newFile);
		fileMenu.add(loadFile);
		fileMenu.add(saveFile);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
	} // end init menuBar
	
	private void initColorPanel () {
	
		//init a pannel to hold to color buttons
		colorPanel = new JPanel();
		colorPanel.setLayout(new BoxLayout ( colorPanel, BoxLayout.Y_AXIS) );
		colorPanel.setBackground(Color.gray);
		colorPanel.setMinimumSize(new Dimension( 50, 450) );
		
		//make a menu from the menu class and initialise it with go();
		colorMenu = new Menu();
		colorMenu.go();
				
		for ( JButton button : colorMenu.colorButtons ) {
			colorPanel.add(button);
		}
		
		frame.getContentPane().add(BorderLayout.WEST, colorPanel);
	} //end initColorPanel
}