import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class NewFilePanel {
	

	public int[] widthAndHeight () {
		
		int width = 0;
		int height = 0;
		
		try {
			//make newFilePanel and buttons
			JPanel newFilePanel = new JPanel();
			newFilePanel.setMinimumSize(new Dimension (150, 60));
			newFilePanel.setPreferredSize(new Dimension(150, 60));
			JLabel error = new JLabel("");
			error.setBorder(BorderFactory.createEmptyBorder( 0, 0, 10, 0));			
			
			JLabel xLabel = new JLabel("X Value:");
			newFilePanel.add(xLabel);
			
			TextField xField = new TextField();
			xField.setMinimumSize(new Dimension(40, 20));
			xField.setPreferredSize(new Dimension(40, 20));
			xField.addKeyListener(new KeyAdapter() {
				
				//disable the input unless a number, arrow keys, delete or backspace is pressed
				public void keyPressed(KeyEvent ke) {
					String value = xField.getText();
					int l = value.length();
					if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() ==  KeyEvent.VK_DELETE || ( ke.getKeyCode() ==  KeyEvent.VK_LEFT ||  ke.getKeyCode() ==  KeyEvent.VK_RIGHT )) {
						xField.setEditable(true);
						error.setText("");
					} else {
					   xField.setEditable(false);
					   error.setText("Please enter a number");
					}
				}
			});
			
			newFilePanel.add(xField);
			
			JLabel yLabel = new JLabel("Y Value:");
			newFilePanel.add(yLabel);
			
			TextField yField = new TextField();
			yField.setMinimumSize(new Dimension(40, 20));
			yField.setPreferredSize(new Dimension(40, 20));
			yField.addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent ke) {
					String value = yField.getText();
					int l = value.length();
					if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() ==  KeyEvent.VK_DELETE || ( ke.getKeyCode() ==  KeyEvent.VK_LEFT ||  ke.getKeyCode() ==  KeyEvent.VK_RIGHT )) {
						yField.setEditable(true);
						error.setText("");
					} else {
					   yField.setEditable(false);
					   error.setText("Please enter a number");
					}
				}
			});
			
			newFilePanel.add(yField);
			
			//add error last to put it at the bottom
			newFilePanel.add(error);

			int result = JOptionPane.showConfirmDialog(null, newFilePanel, 
				"Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
				
				if (result == JOptionPane.OK_OPTION) {
					
					try {
					width = Integer.parseInt(xField.getText());
					height = Integer.parseInt(yField.getText());
					} catch ( NumberFormatException e) {
						e.printStackTrace();
					}
				}
	
		} catch ( Exception e ) {
			
			e.printStackTrace();
			
		}
				
		int[] widthHeight =  { width, height } ; 
				
		return widthHeight;
		
	}
}