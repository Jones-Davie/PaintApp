import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Paint {
	
	//make a window for the app
	JFrame frame;
	JMenuBar menuBar;
	Menu colorMenu;
	JPanel colorPanel;
	DrawPanel drawPanel;
	
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
		initDrawPanel();
		frame.setVisible(true);
	}
	

	//initialisation methods
	
	private void initFrame ( int w, int h ) {
		
		frame = new JFrame("DrawApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if ( h == 0 || w == 0) {
			frame.setSize(860, 600);
			
		} else {
			frame.setSize( (w + 60), h);
		}
		
		
		
	} // end init frame
	

	private void initMenuBar() {
		
		menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("file");
		
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem loadFile = new JMenuItem("Load file");
		JMenuItem saveFile = new JMenuItem("Save File");
		
		newFile.addActionListener(new newFileListener());
		loadFile.addActionListener(new loadFileListener());
		saveFile.addActionListener(new saveFileListener());
		
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
	
	private void initDrawPanel () {
		
		drawPanel = new DrawPanel();
		drawPanel.go();
		frame.add(BorderLayout.CENTER, drawPanel);
		
	}
	
	
	//listener classes
	public class newFileListener implements ActionListener {
		public void actionPerformed ( ActionEvent ev) {
			
			int [] heightWidth;
			
			System.out.println("newFileListener");
			
			try {
					
						
			} catch (Exception ex ) {
				ex.printStackTrace();
			}
			
		}
	}
	
	public class loadFileListener implements ActionListener {
		public void actionPerformed ( ActionEvent ev) {
			System.out.println("loadFileListener");
		}
	}
	
	public class saveFileListener implements ActionListener {
		public void actionPerformed ( ActionEvent ev) {
			System.out.println("saveFileListener");
		}
	}
	
}