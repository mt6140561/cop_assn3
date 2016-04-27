import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
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



public class fourplayerserver extends JPanel implements ActionListener{
	
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
	public fourplayerserver(int i,int k) {
		pressedKeys = new HashMap<>();
		bats = new ArrayList<>();
		balls = new ArrayList<>();
		setSize(600, 600);
		setLayout(null);
		//setBackground(Color.BLACK);
		players = i;
//		Bat bat1 = new Bat(0, 0, 150, 3, 1);
//		Bat bat2 = new Bat(0, 0, 150, 3, 2);
//		Bat bat3 = new Bat(getWidth()-10, 0, 150, 3, 3);
//		Bat bat4 = new Bat(0, getHeight()-10, 150, 3, 4);
		if(k>=3){
			k=3;
		}
		addBalls(k);
		
//		add(bat1);
//		add(bat2);
//		add(bat3);
//		add(bat4);
		addBat(1);
		
		addBat(2);
		addBat(3);
		addBat(4);
	
		tm = new Timer (5, this);
		tm.start();
//		System.out.println((new Vector(1,7)).distance(new Vector(4,3)));
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
	
	
	
	
	static SocketServerExample sse;
	public static void main (String[] args) throws Exception {
		
	
		server1 = new ServerSocket(111);
		server2 = new ServerSocket(222);
		server3=new ServerSocket(333);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setContentPane(new fourplayerserver(4,2));
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
	//		System.out.println(bats.get(0).counter+" 0 ka");
			} else {
				bats.get(2).counter = bats.get(2).counter-1;
   //				System.out.println(bats.get(2).counter+" 2 ka");
			}
			ball.vx = -ball.vx;
		}
		
		
		
	}
	
	public void abc(){
		if(time%15000==0) {
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
		if(time%20000==0){
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
//		
//		if (bats.get(1).x<superspeedball.x+7.5&& bats.get(1).x+bats.get(1).length>superspeedball.x+7.5 && superspeedball.y<bats.get(1).y){
//			bats.get(1).move=6;
//            superspeedball.setVisible(false);
//
//		
//		}
		
//		if (bats.get(3).x<superspeedball.x+7.5&& bats.get(3).x+bats.get(3).length>superspeedball.x+7.5 && superspeedball.y>bats.get(3).y){
//			bats.get(3).move=6;
//			superspeedball.setVisible(false);
//		}
//		
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
		if(time%10000==0){
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
//		
//		if (bats.get(1).x<extralifeball.x+7.5&& bats.get(1).x+bats.get(1).length>extralifeball.x+7.5 && extralifeball.y<bats.get(1).y){
//			
//			if(extralifeball.taken==false){
//				extralifeball.taken=true;
//				bats.get(1).counter=bats.get(1).counter+1;
//			}
//            extralifeball.setVisible(false);
//
//		
//		}
//		
//		if (bats.get(3).x<extralifeball.x+7.5&& bats.get(3).x+bats.get(3).length>extralifeball.x+7.5 && extralifeball.y>bats.get(3).y){
//			if(extralifeball.taken==false){
//				extralifeball.taken=true;
//				bats.get(3).counter=bats.get(3).counter+1;
//			}
//			extralifeball.setVisible(false);
//		}
		
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
		if(time%30000==0){
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
//		
//		if (bats.get(1).x<stonewallball.x+7.5&& bats.get(1).x+bats.get(1).length>stonewallball.x+7.5 && stonewallball.y<bats.get(1).y){
//			bats.get(1).Stonewall=true;
//            stonewallball.setVisible(false);
//
//		
//		}
//		
//		if (bats.get(3).x<stonewallball.x+7.5&& bats.get(3).x+bats.get(3).length>stonewallball.x+7.5 && stonewallball.y>bats.get(3).y){
//			bats.get(3).Stonewall=true;
//			stonewallball.setVisible(false);
//		}
//		
		if (bats.get(2).y<stonewallball.y+7.5&& bats.get(2).y+bats.get(2).length>stonewallball.y+7.5 && stonewallball.x>bats.get(2).x){
			bats.get(2).Stonewall=true;
			stonewallball.setVisible(false);
		}
		
		if (bats.get(0).y<stonewallball.y+7.5&& bats.get(0).y+bats.get(0).length>stonewallball.y+7.5 && stonewallball.x<bats.get(0).x){
			bats.get(0).Stonewall=true;
			stonewallball.setVisible(false);
		}
		

	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
		time = time + 5;
		repaint();
		abc();
		Superspeed();
		extralife();
		Stonewall();
		Color c= Color.CYAN;
		if(bats.get(0).Stonewall==true){
			this.getGraphics().setColor(c);;
			this.getGraphics().fillRect(0, 0, 2, 600);
			this.getGraphics().setColor(c);
			this.getGraphics().drawRect(0, 0, 2, 600);	
		}
//		if(bats.get(3).Stonewall==true){
//			this.getGraphics().setColor(c);
//			this.getGraphics().fillRect(0, 598, 600, 2);
//			this.getGraphics().setColor(c);
//			this.getGraphics().drawRect(0, 598, 600, 2);
//		}
//		if(bats.get(1).Stonewall==true){
//			this.getGraphics().setColor(c);
//			this.getGraphics().fillRect(0, 0, 600, 2);
//			this.getGraphics().setColor(c);
//			this.getGraphics().drawRect(0, 0, 600, 2);
//		}
       if(bats.get(2).Stonewall==true){
			this.getGraphics().setColor(c);;
			this.getGraphics().fillRect(598, 0, 2, 600);
			this.getGraphics().setColor(c);
			this.getGraphics().drawRect(598, 0, 2, 600);	
		}
		for(int k = 0; k<balls.size(); k++) {
			Ball ball = balls.get(k);
		//	bats.get(0).toAI();
			//bats.get(2).toAI();
//			bats.get(1).toAI();
			//bats.get(3).toAI();
//			bats.get(1).addAI(ball, pressedKeys);
//			bats.get(3).addAI(ball, pressedKeys);
//			ballWall(ball);
//			for (int o = 0; o<bats.size(); o++){
//				bats.get(o).ballColl(ball);
//				
//			}
//			System.out.println(ball.vx+", "+ball.vy+", "+ k);
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
//						System.out.println(bats.get(1).counter+" 1 ka");
					} else {
						if (bats.get(3).Stonewall == false){
							bats.get(3).counter = bats.get(3).counter-1;
						}
						
						bats.get(3).changeLength(150);
						bats.get(3).Stonewall = false;
						bats.get(3).move = 8;
//						System.out.println(bats.get(3).counter+" 3 ka");
					}
				//	System.out.println(ball.vy+", "+k);
					ball.vy = -ball.vy;
					//System.out.println(ball.vy+", "+k);
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

//					System.out.println(bats.get(0).counter+" 0 ka");
				} else {
					if (bats.get(2).Stonewall == false){
						bats.get(2).counter = bats.get(2).counter-1;
					}
					bats.get(2).changeLength(150);
					bats.get(2).Stonewall = false;
					bats.get(2).move = 8;

//					System.out.println(bats.get(2).counter+" 2 ka");
				}
				//System.out.println(ball.vx+", "+k);
				ball.vx = -ball.vx;
				//System.out.println(ball.vx+", "+k);
			}
			if ((isBetween(ball.centre.x, bats.get(1).x, bats.get(1).length)&&ball.centre.y<=bats.get(1).y+10+7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(bats.get(1).velo);
				ball.setLocation(ball.x, bats.get(1).y+10);
//				bats.get(1).changeLength(250);
			} else if ((isBetween(ball.centre.x, bats.get(3).x, bats.get(3).length)&&ball.centre.y>=bats.get(3).y-7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(bats.get(3).velo);
				ball.setLocation(ball.x, bats.get(3).y-15);
//				bats.get(3).changeLength(250);
			}
			if ((isBetween(ball.centre.y, bats.get(0).y, bats.get(0).length)&&ball.centre.x<=bats.get(0).x+10+7.5)){
				ball.vx = -ball.vx;
//				System.out.println(ball.vy);
				ball.vy = ball.vy-(bats.get(0).velo);
//				System.out.println(ball.vy);
				ball.setLocation(bats.get(0).x+10, ball.y);
//				bats.get(0).changeLength(250);
			} else if ((isBetween(ball.centre.y, bats.get(2).y, bats.get(2).length)&&ball.centre.x>=bats.get(2).x-7.5)){
				ball.vx = -ball.vx;
				ball.vy = ball.vy-(bats.get(2).velo);
				ball.setLocation(bats.get(2).x-15, ball.y);
//				bats.get(2).changeLength(250);
			}
//			ballWall(ball);
			
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
//					System.out.println(bat.velo);
				} else {bat.velo = 0;}
			}
		}
		ballColl();
		
		bats.get(1).setVisible(false);
		bats.get(3).setVisible(false);
		socketfn();
		
	}
	
	
	
	Socket socket2;
	boolean abc= true;
	
	
	public void socketfn(){

	
		
		String s=" ";
		
	
		if(time%2000==0||time<1000){
		for(int i=0;i<balls.size();i++){
			
			Ball ball=balls.get(i);
		s=s+ball.x+" "+ball.y+" "+ ball.vx+" "+ball.vy+" ";	
		}
		s= s+" "+"time"+time;
		
		}
		
		
		if(abc==true){
				try{
			//System.out.println("asdasd");
	    	socket=server1.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        	String mess = (String) ois.readObject();
        //	System.out.print("assa");
        	
        	String[] abcd = mess.split("\\s+");
        	bats.get(0).setLocation(Integer.parseInt(abcd[0]), Integer.parseInt(abcd[1]));
        	bats.get(0).velo=Integer.parseInt(abcd[2]);
        	 
	            ois.close();
	          
        	 socket.close();
 	    	socket=server2.accept();

             ois = new ObjectInputStream(socket.getInputStream());
        	 mess = (String) ois.readObject();
        //	System.out.print("assa");
        	
        	 abcd = mess.split("\\s+");
        	bats.get(1).setLocation(Integer.parseInt(abcd[0]), Integer.parseInt(abcd[1]));
        	bats.get(1).velo=Integer.parseInt(abcd[2]);
        	 
	            ois.close();
	          
        	 socket.close();
//
//  	    	socket=server3.accept();
//
//            ois = new ObjectInputStream(socket.getInputStream());
//       	 mess = (String) ois.readObject();
//       //	System.out.print("assa");
//       	
//       	 abcd = mess.split("\\s+");
//       	bats.get(1).setLocation(Integer.parseInt(abcd[0]), Integer.parseInt(abcd[1]));
//       	bats.get(1).velo=Integer.parseInt(abcd[2]);
//       	 
//	            ois.close();
//	          
//       	 socket.close();
//        	 
        	 
        	 
	        	 }
			
		
		
		
		
		
		
		
		catch(Exception e){
			abc=false;
			e.printStackTrace();
			bats.get(0).toAI();
		}	}
		
		else{
			bats.get(0).toAI();
		}
		
		repaint();
	}
	
	static ServerSocket server1;
	static ServerSocket server2;
	static ServerSocket server3;
	
	
	 
	    //socket server port on which it will listen
	static  Socket socket;
	   
	
	public boolean isBetween(double x, double start, double range){
		return (x>=start&&x<=start+range);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int fontSize = 20;
		g.setFont(new Font("", Font.PLAIN, fontSize));
	    g.setColor(Color.red);
	  //  g.drawString("lives left  = " + bats.get(1).counter, 250, 30);
	    g.drawString("lives left  = " + bats.get(0).counter, 30, 300);
	   // g.drawString("lives left  = " + bats.get(3).counter, 250, 570);
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
					//		System.out.println(b1.vx+", "+b1.vy+",/ "+((sin*sin)+(cos*cos))+",/ "+b2.vx+", "+b2.vy);
						}
					}
				}
			}
		}
	}
}












