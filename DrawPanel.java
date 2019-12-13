import java.util.*;
import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
		
	private ArrayList<PixelBox> pixelBoxes;
	private int maxWidth;
	private int maxHeigth;
	private Color color;
	private int x;
	private int y;
	
	public void go () {
		
		pixelBoxes = new ArrayList<PixelBox>();
		
		for (int i = 0; i < (( maxHeigth * maxWidth) - 1); i++ ) {
				
			PixelBox pxBox = new PixelBox();
			pxBox.setPixelNumber( i );
			pixelBoxes.add(pxBox);
		}
		
			System.out.println("drawPanel called");
	}
	
	public class PixelBox {
			
			public Color pixelColor = Color.WHITE;
			public int pixelNumber;
			
			public void setPixelNumber( int pxNumber ) {
				pixelNumber = pxNumber;
			}
			
			public void setPixelColor( Color c ) {
				pixelColor = c;
			}
	}
	
	public void paintComponent ( Graphics g ) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		for ( PixelBox pxBox : pixelBoxes ) {
			
			g.setColor( pxBox.pixelColor );
			
			if ( x > (maxWidth-1) ) {
				x = 0;
				y++;
			}
			
			g.fillRect(x,y, 1,1);
			x++;
		}
		
		x = 0;
		y = 0;
	}	
	
	public void setWidth( int w ) {
		maxWidth = w;
	}
	
	public void setHeigth (int h) {
		maxHeigth = h;
	}
	
}