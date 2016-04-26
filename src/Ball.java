import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;


public class Ball extends JLabel {
	public int x;
	public int y;
	public double vx;
	public double vy;
	public Vector centre;
	public double r = 7.5;
	public boolean taken = false;
	public Color color = Color.RED;
	
	public int randomselect(){
		int vxx = (int)(Math.random()*15-Math.random()*15);
		if(vxx==0){
			vxx=randomselect();
		}
		
		return vxx;
		
	}
	public Ball(int x, int y) {
		this.x = x;
		
		this.y = y;
		vx = randomselect();
		vy = randomselect();
		
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
