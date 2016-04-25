import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;



public class Contains extends JPanel implements ActionListener{
	
	public HashMap<String, Bat> pressedKeys;
	public ArrayList<Ball> balls;
	public ArrayList<Bat> bats;
	Timer tm;
	public int players;
	/**
	 * Create the panel.
	 */
	public Contains(int i) {
		pressedKeys = new HashMap<>();
		bats = new ArrayList<>();
		balls = new ArrayList<>();
		setSize(600, 600);
		setLayout(null);
		players = i;
		Bat bat1 = new Bat(0, 0, 150, 3, 1);
		Bat bat2 = new Bat(0, 0, 150, 3, 2);
		Bat bat3 = new Bat(getWidth()-10, 0, 150, 3, 3);
		Bat bat4 = new Bat(0, getHeight()-10, 150, 3, 4);
		addBalls(3);
		add(bat1);
		add(bat2);
		add(bat3);
		add(bat4);
		tm = new Timer (10, this);
		tm.start();
		System.out.println((new Vector(1,7)).distance(new Vector(4,3)));
	}
	
	public void add(Bat bat){
		bat.addAction2(pressedKeys);
		bats.add(bat.pos-1, bat);
		System.out.println(bat.getSize().getWidth());
//		System.out.println(isBetween(2,1,3));
		super.add(bat);
	}
		
	public void add(Ball ball){
		super.add(ball);
		balls.add(ball);
	}
	
	public void addBalls(int i){
		for (int j = 1; j<=i; j++){
			Ball ball = new Ball(100*j, 100*j);
			add(ball);
		}
	}
	
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setContentPane(new Contains(4));
		frame.setLayout(null);
		frame.pack();
		frame.setSize(600+frame.getInsets().right+frame.getInsets().left+1, 600+frame.getInsets().top+frame.getInsets().bottom+1);
		frame.setVisible(true);
	}
	
	public void ballWall(Ball ball){
		double bx = ball.getLocation().getX();
		double by = ball.getLocation().getY();
		double newbx = bx+ball.vx;
		double newby = by+ball.vy;
		if (newbx>=0&&newbx<ball.getParent().getWidth()-15) {
			if ((newby>=0&&newby<ball.getParent().getHeight()-15)) {
				ball.setLocation((int)newbx, (int)newby);
			} else {
				ball.setLocation((int)newbx, (int)by);
				if (ball.vy<0){
					bats.get(1).counter = bats.get(1).counter-1;
//					System.out.println(bats.get(1).counter+" 1 ka");
				} else {
					bats.get(3).counter = bats.get(3).counter-1;
//					System.out.println(bats.get(3).counter+" 3 ka");
				}
				ball.vy = -ball.vy;
			}
		} else {
			ball.setLocation((int)bx, (int)newby);
			if (ball.vx<0){
				bats.get(0).counter = bats.get(0).counter-1;
//				System.out.println(bats.get(0).counter+" 0 ka");
			} else {
				bats.get(2).counter = bats.get(2).counter-1;
//				System.out.println(bats.get(2).counter+" 2 ka");
			}
			ball.vx = -ball.vx;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		for(int k = 0; k<balls.size(); k++) {
			Ball ball = balls.get(k);
	//		bats.get(0).addAI(ball, pressedKeys);
//			bats.get(2).addAI(ball, pressedKeys);
//			bats.get(1).addAI(ball, pressedKeys);
//			bats.get(3).addAI(ball, pressedKeys);
			ballWall(ball);
//			for (int o = 0; o<bats.size(); o++){
//				bats.get(o).ballColl(ball);
//				
//			}
			if ((isBetween(ball.centre.x, bats.get(1).x, bats.get(1).length)&&ball.centre.y<=bats.get(1).y+10+7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(bats.get(1).velo/4);
				ball.setLocation(ball.x, bats.get(1).y+10);
				bats.get(1).changeLength(250);
			} else if ((isBetween(ball.centre.x, bats.get(3).x, bats.get(3).length)&&ball.centre.y>=bats.get(3).y-7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(bats.get(3).velo/4);
				ball.setLocation(ball.x, bats.get(3).y-15);
				bats.get(3).changeLength(250);
			}
			if ((isBetween(ball.centre.y, bats.get(0).y, bats.get(0).length)&&ball.centre.x<=bats.get(0).x+10+7.5)){
				ball.vx = -ball.vx;
				ball.vy = ball.vy-(bats.get(0).velo/4);
				ball.setLocation(bats.get(0).x+10, ball.y);
				bats.get(0).changeLength(250);
			} else if ((isBetween(ball.centre.y, bats.get(2).y, bats.get(2).length)&&ball.centre.x>=bats.get(2).x-7.5)){
				ball.vx = -ball.vx;
				ball.vy = ball.vy-(bats.get(2).velo/4);
				ball.setLocation(bats.get(2).x-15, ball.y);
				bats.get(2).changeLength(250);
			}
			ballWall(ball);
			
		}
		int dir = 0;
		
		Iterator l = pressedKeys.entrySet().iterator();
		while (l.hasNext()) {
			HashMap.Entry i = (HashMap.Entry)l.next();
			Bat bat = (Bat) i.getValue();
			String key = (String) i.getKey();
			String s = key.substring(8);
			
			dir = 0;
			if (s.equals("UP")||s.equals("I")||s.equals("W")||s.equals("RIGHT")) {
				dir = bat.move;
			} else {dir = -1*bat.move;}
			if (bat.pos == 1||bat.pos == 3){
				if (bat.getLocation().getY()-dir>=0&&bat.getLocation().getY()-dir<=bat.getParent().getHeight()-bat.length){
					bat.setLocation(bat.x, bat.y-dir);
					bat.velo = dir/4;
//					System.out.println(bat.velo);
				} else {bat.velo = 0;}
			} else {
				if (bat.getLocation().getX()+dir>=0&&bat.getLocation().getX()+dir<=bat.getParent().getHeight()-bat.length){
					bat.setLocation(bat.x+dir, bat.y);
					bat.velo = dir;
//					System.out.println(bat.velo);
				} else {bat.velo = 0;}
			}
		}
		ballColl();
	}
	
	public boolean isBetween(double x, double start, double range){
		return (x>=start&&x<=start+range);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int fontSize = 20;

	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	     
	    g.setColor(Color.RED);
	    
	    g.drawString(bats.get(0).counter+"", 100, 200);
	}
	
	public void ballColl(){
		for (int j = 0; j<balls.size(); j++){
			for (int i = j; i<balls.size(); i++){
				if (i!=j){
					Ball b1 = balls.get(i);
					Ball b2 = balls.get(j);
					Vector c1c2 = new Vector(b2.centre.x - b1.centre.x, b2.centre.y - b1.centre.y);
					
					if (c1c2.mod()<=15){
						
						double cos = (c1c2.dotProd(new Vector(1, 0)))/c1c2.mod();
						double sin = (c1c2.dotProd(new Vector(0, 1)))/c1c2.mod();
						System.out.println("15 != "+c1c2.mod());
						System.out.println(b2.centre.x+", "+b2.centre.y);
						b2.centre.x = b1.centre.x + 15*cos;
						b2.centre.y = b1.centre.y + 15*sin;
						System.out.println(b2.centre.x+", "+b2.centre.y);
						b2.setLocation((int)(b2.centre.x-7.5), (int)(b2.centre.y-7.5));
						double v2r = b1.vx*cos + b1.vy*sin;
						double v1r = b2.vx*cos + b2.vy*sin;
						double v1t = b1.vy*cos - b1.vx*sin;
						double v2t = b2.vy*cos - b2.vx*sin;
						b1.vx = (v1r*cos - v1t*sin);
						b1.vy = (v1r*sin + v1t*cos);
						b2.vx = (v2r*cos - v2t*sin);
						b2.vy = (v2r*sin + v2t*cos);
						System.out.println("Vector: "+c1c2.x+", "+c1c2.y+",/ "+((sin*sin)+(cos*cos))+",/ "+b1.vx+", "+b1.vy);
					}
				}
			}
		}
	}
}















