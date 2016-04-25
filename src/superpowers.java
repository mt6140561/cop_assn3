import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;


public class superpowers extends JLabel {
	public int x;
	public int y;
	public double vx;
	public double vy;
	public Vector centre;
	public double r = 7.5;
	public boolean taken = false;
	public Color color;
	public superpowers(int x, int y) {
		this.x = x;
		
		this.y = y;
		vx = (int)(Math.random()*4)-2;
		vy = (int)(Math.random()*4)-2;
		if (vx==0){vx = 2;}
		if (vy==0){vy = 2;}
		centre = new Vector(x+r, y+r);
		setLocation(x, y);
		setSize(new Dimension(x+15, y+15));
	}
	
	public void setLocation(int x, int y){
		centre = new Vector(x+r, y+r);
		super.setLocation(x, y);
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(color);
		g.fillOval(0, 0, 15, 15);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 15, 15);
		
	}

}
