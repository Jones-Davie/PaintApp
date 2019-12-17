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
	JPanel contentPanel;
	DrawPanel drawPanel;
	
	//make boolean to check if it is the first startup
	boolean hasInitialized = false;
		
	private int frameWidth = 800;
	private int frameHeight = 600;
	
	//check if the user has mousedown
	boolean mousedown = false;
	
	//make an initialisation method
	public void go () {
		initFrame( frameWidth, frameHeight );
		initMenuBar();
		initColorPanel();
		initDrawPanel();
		frame.setVisible(true);
	}
	
	//initialisation methods
	
	private void initFrame ( int w, int h ) {
		
		if (!hasInitialized) {
			frame = new JFrame("DrawApp");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		contentPanel = (JPanel) frame.getContentPane();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		
		frameWidth = w;
		frameHeight = h;
			
		if ( (frameWidth + 60) > screenWidth ) {
				frameWidth = (screenWidth - 60);
		}
		
		if ( frameHeight > screenHeight ) {
				frameHeight = screenHeight;
		}
		
		frame.setSize( (frameWidth + 60), frameHeight);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground( Color.LIGHT_GRAY );
		
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
		colorPanel.setBorder(BorderFactory.createRaisedBevelBorder());
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
		
		BorderLayout layout = (BorderLayout) contentPanel.getLayout();
		
		if ( hasInitialized ) {
			contentPanel.remove(drawPanel);
		}
		
		drawPanel = new DrawPanel();
		drawPanel.setWidth(frameWidth);
		drawPanel.setHeigth(frameHeight);
		drawPanel.go();
		frame.add(BorderLayout.CENTER, drawPanel);
		frame.repaint();
		
		//set initialisation to true only after the drawPanel has been initiated aswell, otherwise nullpointer exception
		hasInitialized = true;
		
	}
	
	
	//listener classes
	public class newFileListener implements ActionListener {
		public void actionPerformed ( ActionEvent ev) {
			
			int [] heightWidth;
			
			try {

				NewFilePanel newFilePanel = new NewFilePanel();
				
				//outputs the inputvalues of the user in the order of X value Y value
				int[] newWidthAndHeigth = newFilePanel.widthAndHeight();
				
				if (newWidthAndHeigth[0] > 0 && newWidthAndHeigth[1] > 0) {
					
					System.out.println(newWidthAndHeigth[0] + " " + newWidthAndHeigth[1]);
					frameWidth = newWidthAndHeigth[0];
					frameHeight = newWidthAndHeigth[1];
					
					go();
				} else {
					JOptionPane.showMessageDialog(frame, 
						"File creation failed","Warning",
						JOptionPane.WARNING_MESSAGE);
				}
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