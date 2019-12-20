import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

public class Menu implements ActionListener {
	
	//initialise variables and arrays to hold the buttons, colors
	private Color color = Color.black;
	private String[] colorList = new String []{"red", "orange", "yellow", "green", "blue", "magenta", "pink", "keyblack", "white"};
	JButton[] colorButtons = new JButton[colorList.length];

	public void go () {
	//for each color create a button
		for ( int i = 0; i < colorList.length; i++ ) {
			
			//make a new button
			String buttonText = colorList[i];
			JButton button = new JButton( );
			button.setName(buttonText);
			button.setPreferredSize(new Dimension(50, 50));
			//button.putClientProperty("JComponent.sizeVariant", "large");
			button.setMinimumSize(new Dimension( 50, 50));
			button.setMaximumSize(new Dimension( 50, 50));
			button.addActionListener( this );
			
			String buttonColor = "Color." + buttonText;
			Color color;
			
			try {
				
				Field field = Class.forName("java.awt.Color").getField(buttonText);
				color = (Color)field.get(null);
			
			} catch ( Exception e ) {
				color = null;
			}
			
			//button.setBackground(buttonColor);
			button.setBackground(color);
			
			//set the shortcutkey to the first char of the text variable
			button.setMnemonic( buttonText.charAt(0) );
			
			//set the created button to its slot in the button array
			colorButtons[i] = button;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
			
			JButton source = (JButton) e.getSource();
			Color sourceColor = source.getBackground();
			setColor(sourceColor);
		}
	
	private void setColor ( Color c ) {
		color = c;	
	}
	
	public Color getColor ( ) {
		return color;	
	}
	
}