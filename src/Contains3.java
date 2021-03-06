import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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



public class Contains3 extends JPanel implements ActionListener{
	
	public HashMap<String, Bat> pressedKeys;
	public ArrayList<Ball> balls;
	public ArrayList<Bat> bats;
	Timer tm;
	public int players;
	public superpowers superball;
	public superpowers superspeedball;
	public int time = 10;
	public superpowers extralifeball;
	public superpowers stonewallball;
	/**
	 * Create the panel.
	 */
	public Contains3(int i,int k) {
		this.number=k;
		pressedKeys = new HashMap<>();
		bats = new ArrayList<>();
		balls = new ArrayList<>();
		setSize(600, 600);
		setLayout(null);
		players = i;
		if(k>=3){
			k=3;
		}
		addBalls(k);
		addBat(1);
		addBat(2);
		addBat(3);
		addBat(4);
		tm = new Timer (15, this);
		tm.start();
	}
	
	public void add(Bat bat){
		bat.balls=balls;
//		bat.bats=bats;
		bat.pressedKeys=pressedKeys;
		bat.addAction2(pressedKeys);
		bats.add(bat.pos-1, bat);
		super.add(bat);
	}
	
	public void addBat(int i){
		switch (i)
		{
		case 1:
			Bat bat1 = new Bat(0, 0, 150, 3, 1);
			add(bat1);
			break;
			
		case 2:
			Bat bat2 = new Bat(0, 0, 150, 3, 2);
			add(bat2);
			break;
			
		case 3:
			Bat bat3 = new Bat(getWidth()-10, 0, 150, 3, 3);
			add(bat3);
			break;
		
		case 4:
			Bat bat4 = new Bat(0, getHeight()-10, 150, 3, 4);
			add(bat4);
			break;
		}
	}
	
	static int number=1;
		
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
	
	
	public static Socket socket;
	public static void main (String[] args) throws Exception{
		
	     
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setContentPane(new Contains3(4,number));
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
					if (bats.get(1).Stonewall == false){
						bats.get(1).counter = bats.get(1).counter-1;
					}
					bats.get(1).changeLength(150);
					bats.get(1).Stonewall = false;
					bats.get(1).move = 8;
//					System.out.println(bats.get(1).counter+" 1 ka");
				} else {
					if (bats.get(3).Stonewall == false){
						bats.get(3).counter = bats.get(3).counter-1;
					}
					
					bats.get(3).changeLength(150);
					bats.get(3).Stonewall = false;
					bats.get(3).move = 8;
//					System.out.println(bats.get(3).counter+" 3 ka");
				}
//				System.out.println(ball.vy+", "+k);
				ball.vy = -ball.vy;
				ball.vy = ceilroof(ball.vy);
//				System.out.println(ball.vy+", "+k);
			}
		} else {
			ball.setLocation((int)bx, (int)newby);
			if (ball.vx<0){
				if (bats.get(0).Stonewall == false){	
					bats.get(0).counter = bats.get(0).counter-1;
				}
				bats.get(0).changeLength(150);
				bats.get(0).Stonewall = false;
				bats.get(0).move = 8;

//				System.out.println(bats.get(0).counter+" 0 ka");
			} else {
				if (bats.get(2).Stonewall == false){
					bats.get(2).counter = bats.get(2).counter-1;
				}
				bats.get(2).changeLength(150);
				bats.get(2).Stonewall = false;
				bats.get(2).move = 8;

//				System.out.println(bats.get(2).counter+" 2 ka");
			}
//			System.out.println(ball.vx+", "+k);
			ball.vx = -ball.vx;
			ball.vx = ceilroof(ball.vx);
//			System.out.println(ball.vx+", "+k);
		}
	}
	
	public void abc(){
		if(time%5000==0) {
			superpowers sball = new superpowers (300, 300);
			sball.r=100;
			sball.color=Color.green;
			this.superball = sball;
			add(superball);
			
			
		} else {
			if(time<1000){
			superpowers balll = new superpowers (0, 0);
			this.superball = balll;
			superball.r=0;
			superball.vx=0;
			superball.vy=0;
			superball.x=0;
			superball.y=0;
			
			}		
		}
		
		
		
		int bx = (int)superball.getLocation().getX();
		int by = (int)superball.getLocation().getY();
		int newbx = (int) (bx+superball.vx);
		int newby = (int) (by+superball.vy);
				superball.setLocation(newbx, newby);
		
		if (bats.get(1).x<superball.x+7.5&& bats.get(1).x+bats.get(1).length>superball.x+7.5 && superball.y<bats.get(1).y&&superball.y>0){
			//superball.vy = -superball.vy;
             if(bats.get(1).length==250){
				
			}
			else{
				if(bats.get(1).x +250>=600){
//					bats.get(1).setLocation(350,bats.get(1).y);
					bats.get(1).changeLength(250);
				}else{
					bats.get(1).changeLength(250);
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
					bats.get(3).changeLength(250);
				}else{
					bats.get(3).changeLength(250);
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
					bats.get(2).changeLength(250);
				}else{
					bats.get(2).changeLength(250);
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
					bats.get(0).changeLength(250);
//					System.out.println("hua");
				}else{
					bats.get(0).changeLength(250);
				}	
			}
			superball.setVisible(false);
		}
	}
	
	public void Superspeed(){
		if(time%21000==0){
			superpowers ssball = new superpowers (300, 400);
			ssball.r=100;
			ssball.color=Color.DARK_GRAY;
			this.superspeedball = ssball;
			add(superspeedball);
			
			
		}else{if(time<1000){
			superpowers baalll = new superpowers (0, 0);
			this.superspeedball = baalll;
			superspeedball.r=0;
			superspeedball.vx=0;
			superspeedball.vy=0;
			superspeedball.x=0;
			superspeedball.y=0;
			}
		}
		
		
		int bx = (int)superspeedball.getLocation().getX();
		int by = (int)superspeedball.getLocation().getY();
		int newbx = (int) (bx+superspeedball.vx);
		int newby = (int) (by+superspeedball.vy);
		superspeedball.setLocation(newbx, newby);
		
		if (bats.get(1).x<superspeedball.x+7.5&& bats.get(1).x+bats.get(1).length>superspeedball.x+7.5 && superspeedball.y<bats.get(1).y){
			bats.get(1).move=6;
            superspeedball.setVisible(false);

		
		}
		
		if (bats.get(3).x<superspeedball.x+7.5&& bats.get(3).x+bats.get(3).length>superspeedball.x+7.5 && superspeedball.y>bats.get(3).y){
			bats.get(3).move=6;
			superspeedball.setVisible(false);
		}
		
		if (bats.get(2).y<superspeedball.y+7.5&& bats.get(2).y+bats.get(2).length>superspeedball.y+7.5 && superspeedball.x>bats.get(2).x){
			bats.get(2).move=6;
			superspeedball.setVisible(false);
		}
		
		if (bats.get(0).y<superspeedball.y+7.5&& bats.get(0).y+bats.get(0).length>superspeedball.y+7.5 && superspeedball.x<bats.get(0).x){
			bats.get(0).move=6;
			superspeedball.setVisible(false);
		}
		

	}
	
	public void extralife(){
		if(time%8000==0){
			superpowers ssball = new superpowers (300, 400);
			ssball.r=100;
			ssball.color=Color.pink;
			this.extralifeball = ssball;
			add(extralifeball);
			
			
		}else{if(time<1000){
			superpowers baalll = new superpowers (0, 0);
			this.extralifeball = baalll;
			extralifeball.r=0;
			extralifeball.vx=0;
			extralifeball.vy=0;
			extralifeball.x=0;
			extralifeball.y=0;
			
		}}
		
		
		int bx = (int)extralifeball.getLocation().getX();
		int by = (int)extralifeball.getLocation().getY();
		int newbx = (int) (bx+extralifeball.vx);
		int newby = (int) (by+extralifeball.vy);
				extralifeball.setLocation(newbx, newby);
		
		if (bats.get(1).x<extralifeball.x+7.5&& bats.get(1).x+bats.get(1).length>extralifeball.x+7.5 && extralifeball.y<bats.get(1).y){
			
			if(extralifeball.taken==false){
				extralifeball.taken=true;
				bats.get(1).counter=bats.get(1).counter+1;
			}
            extralifeball.setVisible(false);

		
		}
		
		if (bats.get(3).x<extralifeball.x+7.5&& bats.get(3).x+bats.get(3).length>extralifeball.x+7.5 && extralifeball.y>bats.get(3).y){
			if(extralifeball.taken==false){
				extralifeball.taken=true;
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
			if(extralifeball.taken==false){
				extralifeball.taken=true;
				bats.get(0).counter=bats.get(0).counter+1;
			}
			extralifeball.setVisible(false);
		}
		

	}
	
	public void Stonewall(){
		if(time%31000==0){
			superpowers ssball = new superpowers (300, 400);
			ssball.r=100;
			ssball.color=Color.YELLOW;
			this.stonewallball = ssball;
			add(stonewallball);
			
			
		}else{if(time<1000){
			superpowers baalll = new superpowers (0, 0);
			this.stonewallball = baalll;
			stonewallball.r=0;
			stonewallball.vx=0;
			stonewallball.vy=0;
			stonewallball.x=0;
			stonewallball.y=0;
			}
		}
		int bx = (int)stonewallball.getLocation().getX();
		int by = (int)stonewallball.getLocation().getY();
		int newbx = (int) (bx+stonewallball.vx);
		int newby = (int) (by+stonewallball.vy);
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
	
	
	
	
		
	public boolean isBetween(double x, double start, double range){
		return (x>=start&&x<=start+range);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int fontSize = 20;
		g.setFont(new Font("", Font.PLAIN, fontSize));
	    g.setColor(Color.red);
	    g.drawString("lives left  = " + bats.get(1).counter, 250, 30);
	    g.drawString("lives left  = " + bats.get(0).counter, 30, 300);
	    g.drawString("lives left  = " + bats.get(3).counter, 250, 570);
	    g.drawString("lives left  = " + bats.get(2).counter, 470,300);
	    
	}
	
	public double ceilroof(double a){
		if (a<1&&a>0){
			a = 1;
		} else if (a<0&&a>-1){
			a = -1;
		}
		return a;
	}
	
	public void decipher(String sa[][]){
		for(int i=0;i<sa.length;i++){
			if(sa[i][0].equals("ballposition")){
				balls.get(0).x=Integer.parseInt(sa[i][1]);
				balls.get(0).y=Integer.parseInt(sa[i][2]);
			}
			if(sa[i][0].equals("batposition")){
				bats.get(2).x=Integer.parseInt(sa[i][1]);
				bats.get(2).y=Integer.parseInt(sa[i][2]);
			}
			if(sa[i][0].equals("length")){
				bats.get(2).length=Integer.parseInt(sa[i][1]);
			}
			if(sa[i][0].equals("life")){
				bats.get(2).counter=Integer.parseInt(sa[i][1]);
			}
			
		}
	}
	
	public void ballColl(){
		for (int j = 0; j<balls.size(); j++){
			for (int i = j; i<balls.size(); i++){
				if (i!=j){
					Ball b1 = balls.get(i);
					Ball b2 = balls.get(j);
					Vector c1c2 = new Vector(b2.centre.x - b1.centre.x, b2.centre.y - b1.centre.y);
					
					if (c1c2.mod()<=15){
						if (c1c2.mod()<1e-12){} 
						else {
							double cos = (c1c2.dotProd(new Vector(1, 0)))/c1c2.mod();
	//						double sin = (c1c2.dotProd(new Vector(0, 1)))/c1c2.mod();
							double sin = Math.sqrt(1-(cos*cos));
							if (c1c2.y<0){
								sin = -sin;
							}
//							System.out.println("15 != "+c1c2.mod());
//							System.out.println(b2.centre.x+", "+b2.centre.y);
							b2.centre.x = b1.centre.x + 15*cos;
							b2.centre.y = b1.centre.y + 15*sin;
//							System.out.println(b2.centre.x+", "+b2.centre.y);
							b2.setLocation((int)(b2.centre.x-7.5), (int)(b2.centre.y-7.5));
							double v2r = b1.vx*cos + b1.vy*sin;
							double v1r = b2.vx*cos + b2.vy*sin;
							double v1t = b1.vy*cos - b1.vx*sin;
							double v2t = b2.vy*cos - b2.vx*sin;
							b1.vx = ceilroof(v1r*cos - v1t*sin);
							b1.vy = ceilroof(v1r*sin + v1t*cos);
							b2.vx = ceilroof(v2r*cos - v2t*sin);
							b2.vy = ceilroof(v2r*sin + v2t*cos);
//							System.out.println(b1.vx+", "+b1.vy+",/ "+((sin*sin)+(cos*cos))+",/ "+b2.vx+", "+b2.vy);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		bats.get(1).toAI();
		//bats.get(3).toAI();
		time = time + 10;
		repaint();
		abc();
		Superspeed();
		extralife();
		Stonewall();
		countercheck();
		Color c= Color.CYAN;
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
		for(int k = 0; k<balls.size(); k++) {
			Ball ball = balls.get(k);
			
			for (Bat bat : bats){
				bat.ballBat(ball);
			}
		

//			if ((isBetween(ball.centre.x, bats.get(1).x, bats.get(1).length)&&ball.centre.y<=bats.get(1).y+10+7.5)){
//				ball.vy = -ball.vy;
//				ball.vx = ball.vx+(bats.get(1).velo);
//				ball.setLocation(ball.x, bats.get(1).y+10);
//			} else if ((isBetween(ball.centre.x, bats.get(3).x, bats.get(3).length)&&ball.centre.y>=bats.get(3).y-7.5)){
//				ball.vy = -ball.vy;
//				ball.vx = ball.vx+(bats.get(3).velo);
//				ball.setLocation(ball.x, bats.get(3).y-15);
//			}
//			if ((isBetween(ball.centre.y, bats.get(0).y, bats.get(0).length)&&ball.centre.x<=bats.get(0).x+10+7.5)){
//				ball.vx = -ball.vx;
//				ball.vy = ball.vy-(bats.get(0).velo);
//				ball.setLocation(bats.get(0).x+10, ball.y);
//			} else if ((isBetween(ball.centre.y, bats.get(2).y, bats.get(2).length)&&ball.centre.x>=bats.get(2).x-7.5)){
//				ball.vx = -ball.vx;
//				ball.vy = ball.vy-(bats.get(2).velo);
//				ball.setLocation(bats.get(2).x-15, ball.y);
//			}
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
					bat.velo = dir/8;
//					System.out.println(bat.velo);
				} else {bat.velo = 0;}
			} else {
				if (bat.getLocation().getX()+dir>=0&&bat.getLocation().getX()+dir<=bat.getParent().getHeight()-bat.length){
					bat.setLocation(bat.x+dir, bat.y);
					bat.velo = dir/8;
				} else {bat.velo = 0;}
			}
		}
		ballColl();
	countercheck();	
//		try {
//			
//			
//			socket = new Socket("192.168.56.1", 9876);
//			ObjectInputStream inin=new ObjectInputStream(socket.getInputStream());
//			String message =  (String) inin.readObject();
//			String[] info = message.split("\\s+");
//			System.out.println("hello22");
//			System.out.println(message);
//			
//			bats.get(0).setLocation(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
//			inin.close();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public void countercheck(){
	int c1=	bats.get(0).counter;
	int c2=bats.get(1).counter;
	int c3=	bats.get(2).counter;
	int c4=	bats.get(3).counter;
	
	if(c1<=0){
		
		bats.get(0).setVisible(false);
		bats.get(0).Stonewall=false;
		bats.get(0).y=-400;
		bats.get(0).counter=0;
	}
	
	
if(c3<=0){
		
		bats.get(2).setVisible(false);
		bats.get(2).Stonewall=false;
		bats.get(2).y=-400;
		bats.get(2).counter=0;
	}

if(c2<=0){
	
	bats.get(1).setVisible(false);
	bats.get(1).Stonewall=false;
	bats.get(1).x=-400;
	bats.get(1).counter=0;
}
	
if(c4<=0){
	
	bats.get(3).setVisible(false);
	bats.get(3).Stonewall=false;
	bats.get(3).x=-400;
	bats.get(3).counter=0;
}

if(c1==0&&c2==0&&c3==0&&c4==0){
	this.getGraphics().drawString("GAME OVER",280, 300);
	for(int i=0;i<balls.size();i++){
		balls.get(i).vx=0;
		balls.get(i).vy=0;
		tm.stop();
}

	}

	}

}
