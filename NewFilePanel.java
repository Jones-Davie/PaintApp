import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class NewFilePanel {
	

	public int[] widthAndHeight () {
		
		int width = 0;
		int height = 0;
		
		try {
	
			JPanel newFilePanel = new JPanel();
			newFilePanel.setMinimumSize(new Dimension (300, 150));
			JLabel xLabel = new JLabel("X Value:");
			newFilePanel.add(xLabel);
			
			TextField xField = new TextField();
			xField.addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent ke) {
					String value = xField.getText();
					int l = value.length();
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
						xField.setEditable(true);
						xLabel.setText("X Value:");
					} else {
					   xField.setEditable(false);
					   xLabel.setText("X Value: Enter only numeric digits(0-9)");
					}
				}
			});
			
			newFilePanel.add(xField);
			
			JLabel yLabel = new JLabel("Y Value:");
			newFilePanel.add(yLabel);
			
			TextField yField = new TextField();
			yField.addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent ke) {
					String value = yField.getText();
					int l = value.length();
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
						yField.setEditable(true);
						yLabel.setText("Y Value:");
					} else {
					   yField.setEditable(false);
					   yLabel.setText("Y Value: Enter only numeric digits(0-9)");
					}
				}
			});
			
			newFilePanel.add(yField);
			
			
			int result = JOptionPane.showConfirmDialog(null, newFilePanel, 
				"Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
				
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