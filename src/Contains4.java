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




public class Contains4 extends JPanel implements ActionListener{
	
	public HashMap<String, Bat> pressedKeys;
	public Ball ball;
	public Ball superball;
	public Ball extralifeball;
	public Ball stonewallball;
	public Ball superspeedball;
	public ArrayList<Bat> bats;
	int time=5;
	/**
	 * Create the panel.
	 */
	public Contains4() {
		pressedKeys = new HashMap<>();
		bats = new ArrayList<>();
		setSize(600, 600);
		setLayout(null);
		Bat bat1 = new Bat(0, 0, 150, 3, 1);
		Bat bat2 = new Bat(0, 0, 150, 3, 2);
		Bat bat3 = new Bat(getWidth()-10, 0, 150, 3, 3);
		Bat bat4 = new Bat(0, getHeight()-10, 150, 3, 4);
		
		Ball ball = new Ball (300, 300);
		this.ball = ball;
		bat1.ball=ball;
		bat1.bats=bats;
		bat1.pressedKeys=pressedKeys;
		bat2.ball=ball;
		bat2.bats=bats;
		bat2.pressedKeys=pressedKeys;
		bat3.ball=ball;
		bat3.bats=bats;
		bat3.pressedKeys=pressedKeys;
		
		
		
		bat4.ball=ball;
		bat4.bats=bats;
		bat4.pressedKeys=pressedKeys;
		add(ball);
		add(bat1);
		add(bat2);
		add(bat3);
		add(bat4);

		Timer tm = new Timer (5, this);
		tm.start();
		
	}
	
	public void add(Bat bat){
		bat.addAction2(pressedKeys);
		bats.add(bat.pos-1, bat);
//		System.out.println(isBetween(2,1,3));
		super.add(bat);
	}
	
	public void abc(){
		if(time%5000==0){
			Ball sball = new Ball (300, 300);
			
			sball.abc=Color.green;
			this.superball = sball;
			System.out.println("qwe");
		add(superball);
			
			
		}else{if(time<1000){
			Ball balll = new Ball (0, 0);
			this.superball = balll;
			superball.r=0;
			superball.vx=0;
			superball.vy=0;
			superball.x=0;
			superball.y=0;
			
		}}
		
		
		
		int bx = (int)superball.getLocation().getX();
		int by = (int)superball.getLocation().getY();
		int newbx = bx+superball.vx;
		int newby = by+superball.vy;
				superball.setLocation(newbx, newby);
		
		if (bats.get(1).x<superball.x+7.5&& bats.get(1).x+bats.get(1).length>superball.x+7.5 && superball.y<bats.get(1).y&&superball.y>0){
			//superball.vy = -superball.vy;
             if(bats.get(1).length==250){
				
			}
			else{
				if(bats.get(1).x +250>=600){
					bats.get(1).setLocation(350,bats.get(1).y);
					bats.get(1).length=250;
				}else{
					bats.get(1).length=250;
				}
//			
		}
superball.setVisible(false);

		
		}
		
		if (bats.get(3).x<superball.x+7.5&& bats.get(3).x+bats.get(3).length>superball.x+7.5 && superball.y>bats.get(3).y&&superball.y<600){
			//superball.vy = -superball.vy;
			repaint();
			if(bats.get(3).length==250){
				
			}
			else{
				if(bats.get(3).x +250>=600){
					bats.get(3).setLocation(350,bats.get(3).y);
					bats.get(3).length=250;
				}else{
					bats.get(3).length=250;
				}
		
			}
			
			
			superball.setVisible(false);
		}
		
		if (bats.get(2).y<superball.y+7.5&& bats.get(2).y+bats.get(2).length>superball.y+7.5 && superball.x>bats.get(2).x&&superball.x<600){
		//	superball.vx = -superball.vx;
        if(bats.get(2).length==250){
				
			}
			else{
				if(bats.get(2).y+250>=600){
					bats.get(2).setLocation(bats.get(2).x,350);
					bats.get(2).length=250;
				}else{
					bats.get(2).length=250;
				}
//			
		}
			superball.setVisible(false);
		}
		
		if (bats.get(0).y<superball.y+7.5&& bats.get(0).y+bats.get(0).length>superball.y+7.5 && superball.x<bats.get(0).x  &&superball.y>0){
		//	superball.vx = -superball.vx;
         if(bats.get(0).length==250){
				
			}
			else{
				if(bats.get(0).y+250>=600){
					bats.get(0).setLocation(bats.get(0).x,350);
					bats.get(0).length=250;
				}else{
					bats.get(0).length=250;
				}
//			
		}
			
			
			superball.setVisible(false);
		}
		

		
		
		
				

	}
	
	
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setContentPane(new Contains4());
		frame.setLayout(null);
		frame.pack();
		frame.setSize(600+frame.getInsets().right+frame.getInsets().left+1, 600+frame.getInsets().top+frame.getInsets().bottom+1);
		frame.setVisible(true);
	}
	
	



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
	    extralife();
		abc();
		Stonewall();
		Superspeed();
//		bats.get(0).toAI();
	//bats.get(1).toAI();
	//	bats.get(2).toAI();
		//bats.get(3).toAI();
		
		Color c= new Color(255, 215, 0);
			if(bats.get(0).Stonewall==true){
				this.getGraphics().setColor(c);;
				this.getGraphics().fillRect(0, 0, 2, 600);
				this.getGraphics().setColor(c);
				this.getGraphics().drawRect(0, 0, 2, 600);	
			}
			if(bats.get(3).Stonewall==true){
				this.getGraphics().setColor(c);
				this.getGraphics().fillRect(0, 598, 600, 2);
				this.getGraphics().setColor(c);
				this.getGraphics().drawRect(0, 598, 600, 2);
			}
			if(bats.get(1).Stonewall==true){
				this.getGraphics().setColor(c);
				this.getGraphics().fillRect(0, 0, 600, 2);
				this.getGraphics().setColor(c);
				this.getGraphics().drawRect(0, 0, 600, 2);
			}
			if(bats.get(2).Stonewall==true){
				this.getGraphics().setColor(c);;
				this.getGraphics().fillRect(598, 0, 2, 600);
				this.getGraphics().setColor(c);
				this.getGraphics().drawRect(598, 0, 2, 600);	
			}
			
			
			
		time=time+5;
		int bx = (int)ball.getLocation().getX();
		int by = (int)ball.getLocation().getY();
		int newbx = bx+ball.vx;
		int newby = by+ball.vy;
		if (newbx>=0&&newbx<ball.getParent().getWidth()-15) {
			if ((newby>=0&&newby<ball.getParent().getHeight()-15)) {
				ball.setLocation(newbx, newby);
			} else {
				ball.setLocation(newbx, by);
				if (ball.vy<0){
					if(bats.get(1).Stonewall==false){
						
					bats.get(1).counter = bats.get(1).counter-1;}
					bats.get(1).move=4;
					bats.get(1).length=150;
					bats.get(1).Stonewall=false;
					
					System.out.println(bats.get(1).counter+" 1 ka");
				} else {
					if(bats.get(3).Stonewall==false){
					bats.get(3).counter = bats.get(3).counter-1;}
					
					bats.get(3).move=4;
					bats.get(3).length=150;
					bats.get(3).Stonewall=false;
					System.out.println(bats.get(3).counter+" 3 ka");
				}
				ball.vy = -ball.vy;
			}
		} else {
			ball.setLocation(bx, newby);
			if (ball.vx<0){
				if(bats.get(0).Stonewall==false){
				bats.get(0).counter = bats.get(0).counter-1;}
				bats.get(0).move=4;
				bats.get(0).length=150;
				bats.get(0).Stonewall=false;
				
				System.out.println(bats.get(0).counter+" 0 ka");
			} else {
				if(bats.get(2).Stonewall==false){
				bats.get(2).counter = bats.get(2).counter-1;}
				bats.get(2).move=4;
				bats.get(2).length=150;
				bats.get(2).Stonewall=false;
				
				
				System.out.println(bats.get(2).counter+" 2 ka");
			}
			ball.vx = -ball.vx;
		}
		if ((isBetween(ball.centre.x, bats.get(1).x, bats.get(1).length)&&ball.centre.y<=bats.get(1).y+10+7.5)){
			ball.vy = -ball.vy;
		//	ball.setLocation(ball.x+ball.vx, bats.get(1).y+10);
		} else if ((isBetween(ball.centre.x, bats.get(3).x, bats.get(3).length)&&ball.centre.y>=bats.get(3).y-7.5)){
			ball.vy = -ball.vy;
		//	ball.setLocation(ball.x+ball.vx, bats.get(3).y-15);
		}
		if ((isBetween(ball.centre.y, bats.get(0).y, bats.get(0).length)&&ball.centre.x<=bats.get(0).x+10+7.5)||(isBetween(ball.centre.y, bats.get(2).y, bats.get(2).length)&&ball.centre.x>=bats.get(2).x-7.5)){
			ball.vx = -ball.vx;
		//	ball.setLocation(ball.x+ball.vx, ball.y+ball.vy);
		}
		ArrayList<Vector> corners = new ArrayList<>();
//		corners.add(new Vector())
		Iterator l = pressedKeys.entrySet().iterator();
		while (l.hasNext()) {
			HashMap.Entry i = (HashMap.Entry)l.next();
			Bat bat = (Bat) i.getValue();
			String key = (String) i.getKey();
			String s = key.substring(8);
			
			int dir = 0;
			if (s.equals("UP")||s.equals("I")||s.equals("W")||s.equals("RIGHT")) {
				dir = bat.move;
			} else {dir = -1*bat.move;}
			if (bat.pos == 1||bat.pos == 3){
				if (bat.getLocation().getY()-dir>=0&&bat.getLocation().getY()-dir<=bat.getParent().getHeight()-bat.length){
					bat.setLocation(bat.x, bat.y-dir);
				} else {}
			} else {
				if (bat.getLocation().getX()+dir>=0&&bat.getLocation().getX()+dir<=bat.getParent().getHeight()-bat.length){
					bat.setLocation(bat.x+dir, bat.y);
				} else {}
			}	
		}
		repaint();
	}
	
	public void aifor3(){
		int a =bats.get(3).findx() ;
		int dis = a - bats.get(3).x - ((bats.get(3).length)/2 );
		System.out.println(a );
		//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
		if(dis>-10 && dis<10)
		{
			pressedKeys.remove("pressed LEFT");
			pressedKeys.remove("pressed RIGHT");
		}
		else
		{
		
		if(a>bats.get(3).x + ((bats.get(3).length)/2)){
			System.out.println("qwweqw");
			pressedKeys.remove("pressed LEFT");
			pressedKeys.put("pressed RIGHT",bats.get(3) );
		}	
		
		else{
			System.out.println("ssss");
			pressedKeys.remove("pressed RIGHT");
			pressedKeys.put("pressed LEFT",bats.get(3) );
		}}
		
	}
	
	public boolean isBetween(double x, double start, double range){
		return (x>=start&&x<=start+range);
	}
	
	public void paintComponent(Graphics g){
	
//		g.setColor(Color.black);
//		g.fillRect(0, 0, 600, 600);
//		
		g.setColor(Color.cyan);
		
		
		super.paintComponent(g);
		int fontSize = 20;
		
		
		
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	     
	    g.setColor(Color.red);
	    
	    g.drawString("lives left  = " + bats.get(1).counter, 250, 30);
	    g.drawString("lives left  = " + bats.get(0).counter, 30, 300);
	    g.drawString("lives left  = " + bats.get(3).counter, 250, 570);
	    g.drawString("lives left  = " + bats.get(2).counter, 470,300);
	    
	}
	
	public void extralife(){
		if(time%8000==0){
			Ball ssball = new Ball (300, 400);
			ssball.r=100;
			ssball.abc=Color.pink;
			this.extralifeball = ssball;
			add(extralifeball);
			
			
		}else{if(time<1000){
			Ball baalll = new Ball (0, 0);
			this.extralifeball = baalll;
			extralifeball.r=0;
			extralifeball.vx=0;
			extralifeball.vy=0;
			extralifeball.x=0;
			extralifeball.y=0;
			
		}}
		
		
		int bx = (int)extralifeball.getLocation().getX();
		int by = (int)extralifeball.getLocation().getY();
		int newbx = bx+extralifeball.vx;
		int newby = by+extralifeball.vy;
				extralifeball.setLocation(newbx, newby);
		
		if (bats.get(1).x<extralifeball.x+7.5&& bats.get(1).x+bats.get(1).length>extralifeball.x+7.5 && extralifeball.y<bats.get(1).y){
			
			if(extralifeball.taken==false)
			{extralifeball.taken=true;
				bats.get(1).counter=bats.get(1).counter+1;
			}
            extralifeball.setVisible(false);

		
		}
		
		if (bats.get(3).x<extralifeball.x+7.5&& bats.get(3).x+bats.get(3).length>extralifeball.x+7.5 && extralifeball.y>bats.get(3).y){
			if(extralifeball.taken==false)
			{extralifeball.taken=true;
			bats.get(3).counter=bats.get(3).counter+1;
			}
			extralifeball.setVisible(false);
		}
		
		if (bats.get(2).y<extralifeball.y+7.5&& bats.get(2).y+bats.get(2).length>extralifeball.y+7.5 && extralifeball.x>bats.get(2).x){
			
			if(extralifeball.taken==false)
			{extralifeball.taken=true;
			bats.get(2).counter=bats.get(2).counter+1;
			}
			extralifeball.setVisible(false);
		}
		
		if (bats.get(0).y<extralifeball.y+7.5&& bats.get(0).y+bats.get(0).length>extralifeball.y+7.5 && extralifeball.x<bats.get(0).x){
			if(extralifeball.taken==false)
			{extralifeball.taken=true;
			bats.get(0).counter=bats.get(0).counter+1;
			}
			extralifeball.setVisible(false);
		}
		

	}
	
	

	
	public void Superspeed(){
		if(time%21000==0){
			Ball ssball = new Ball (300, 400);
			ssball.r=100;
			ssball.abc=Color.DARK_GRAY;
			this.superspeedball = ssball;
			add(superspeedball);
			
			
		}else{if(time<1000){
			Ball baalll = new Ball (0, 0);
			this.superspeedball = baalll;
			superspeedball.r=0;
			superspeedball.vx=0;
			superspeedball.vy=0;
			superspeedball.x=0;
			superspeedball.y=0;
			
		}}
		
		
		int bx = (int)superspeedball.getLocation().getX();
		int by = (int)superspeedball.getLocation().getY();
		int newbx = bx+superspeedball.vx;
		int newby = by+superspeedball.vy;
				superspeedball.setLocation(newbx, newby);
		
		if (bats.get(1).x<superspeedball.x+7.5&& bats.get(1).x+bats.get(1).length>superspeedball.x+7.5 && superspeedball.y<bats.get(1).y){
			bats.get(1).move=2;
            superspeedball.setVisible(false);

		
		}
		
		if (bats.get(3).x<superspeedball.x+7.5&& bats.get(3).x+bats.get(3).length>superspeedball.x+7.5 && superspeedball.y>bats.get(3).y){
			bats.get(3).move=2;
			superspeedball.setVisible(false);
		}
		
		if (bats.get(2).y<superspeedball.y+7.5&& bats.get(2).y+bats.get(2).length>superspeedball.y+7.5 && superspeedball.x>bats.get(2).x){
			bats.get(2).move=2;
			superspeedball.setVisible(false);
		}
		
		if (bats.get(0).y<superspeedball.y+7.5&& bats.get(0).y+bats.get(0).length>superspeedball.y+7.5 && superspeedball.x<bats.get(0).x){
			bats.get(0).move=2;
			superspeedball.setVisible(false);
		}
		

	}
	
	
	public void Stonewall(){
		if(time%11000==0){
			Ball ssball = new Ball (300, 400);
			ssball.r=100;
			ssball.abc=Color.YELLOW;
			this.stonewallball = ssball;
			add(stonewallball);
			
			
		}else{if(time<1000){
			Ball baalll = new Ball (0, 0);
			this.stonewallball = baalll;
			stonewallball.r=0;
			stonewallball.vx=0;
			stonewallball.vy=0;
			stonewallball.x=0;
			stonewallball.y=0;
			
		}}
		
		
		int bx = (int)stonewallball.getLocation().getX();
		int by = (int)stonewallball.getLocation().getY();
		int newbx = bx+stonewallball.vx;
		int newby = by+stonewallball.vy;
				stonewallball.setLocation(newbx, newby);
		
		if (bats.get(1).x<stonewallball.x+7.5&& bats.get(1).x+bats.get(1).length>stonewallball.x+7.5 && stonewallball.y<bats.get(1).y){
			bats.get(1).Stonewall=true;
            stonewallball.setVisible(false);

		
		}
		
		if (bats.get(3).x<stonewallball.x+7.5&& bats.get(3).x+bats.get(3).length>stonewallball.x+7.5 && stonewallball.y>bats.get(3).y){
			bats.get(3).Stonewall=true;
			stonewallball.setVisible(false);
		}
		
		if (bats.get(2).y<stonewallball.y+7.5&& bats.get(2).y+bats.get(2).length>stonewallball.y+7.5 && stonewallball.x>bats.get(2).x){
			bats.get(2).Stonewall=true;
			stonewallball.setVisible(false);
		}
		
		if (bats.get(0).y<stonewallball.y+7.5&& bats.get(0).y+bats.get(0).length>stonewallball.y+7.5 && stonewallball.x<bats.get(0).x){
			bats.get(0).Stonewall=true;
			stonewallball.setVisible(false);
		}
		

	}
	

	
	
}
