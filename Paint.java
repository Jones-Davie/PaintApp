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
	boolean drawPanelAdded = false;
		
	private int frameWidth = 800;
	private int frameHeigth = 600;
	
	//check if the user has mousedown
	boolean mousedown = false;
	
	//make an initialisation method
	public void go () {
		initFrame( frameWidth, frameHeigth );
		initMenuBar();
		initColorPanel();
		initDrawPanel();
		frame.setVisible(true);
	}
	
	//initialisation methods
	
	private void initFrame ( int w, int h ) {
		
		frame = new JFrame("DrawApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = (JPanel) frame.getContentPane();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		
		frameWidth = w;
		frameHeigth = h;
			
		if ( (frameWidth + 60) > screenWidth ) {
				frameWidth = (screenWidth - 60);
		}
		
		if ( frameHeigth > screenHeight ) {
				frameHeigth = screenHeight;
		}
		
		frame.setSize( (frameWidth + 60), frameHeigth);
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
		
		if ( drawPanelAdded ) {
			contentPanel.remove(drawPanel);
		}
		
		drawPanel = new DrawPanel();
		drawPanel.setWidth(frameWidth);
		drawPanel.setHeigth(frameHeigth);
		drawPanel.go();
		frame.add(BorderLayout.CENTER, drawPanel);
		drawPanelAdded = true;
		frame.repaint();
	}
	
	
	//listener classes
	public class newFileListener implements ActionListener {
		public void actionPerformed ( ActionEvent ev) {
			
			int [] heightWidth;
			
			System.out.println("newFileListener");
			
			try {
					frame.setVisible(false);
					frameWidth = 1500;
					frameHeigth = 1100;
					go();
					frame.setVisible(true);
					
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