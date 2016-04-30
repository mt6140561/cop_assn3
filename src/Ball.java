import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;


public class Ball extends JLabel {
	public int x;//x coordinate
	public int y;//y coordinate
	public double vx;// horizontal collision
	public double vy;// vertical velocity
	int k=20;//random constant
	public Vector centre;//centre vector point
	public double r = 7.5;//radius
	public boolean taken = false;//junk
	public Color color = Color.RED;//colour
	
	/*
	 * randomselect(): 	selects random velocity between -k to k.
	 * Ball(x,y): 		sets coordinates of balls
	 * setLocation():	sets location and changes respective fields.
	 * paintComponent():draws the ball
	 */
	
	public int randomselect(){
		int vxx = (int)(Math.random()*k-Math.random()*k);
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
