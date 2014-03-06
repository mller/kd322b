import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class Bargraph extends JComponent {

	private int women;
	private int men;
	private float total;
	
	private int mh;
	private int wh;
	
	public void updateValues(int women, int men){
		this.women = women;
		this.men = men;
		
		total = men+women;
		
		wh = (int)(getHeight() * (men/total));
		mh = getHeight()-wh;
		
		System.out.println(mh + " " + wh);
		System.out.println(men + " " + women);
		repaint();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString(""+(int)total, 60, 13);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 15+mh, getWidth()/2, getHeight());
		g.setColor(Color.RED);
		g.fillRect(140, 15+wh, getWidth()/2, getHeight());
	}
}
