import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Bat extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public int x;
	public int y;
	public int length;
	public int counter;
	public int pos;
	public int velo;
	public int move;

	public HashMap<String, Bat> pressedKeys;
	public ArrayList<Ball> balls;
	public ArrayList<Bat> bats;
	public boolean Stonewall = true;
	public Bat (int x, int y, int length, int counter, int pos) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.counter = counter;
		this.pos = pos;
		this.velo = 0;
		this.move = 8;
		this.setLocation(x, y);
		int x1=-1,y1=-1;
		if (pos == 1 || pos == 3) {
			x1 = 10;
			y1 = length;
		} else if (pos == 2 || pos == 4) {
			x1 = length;
			y1 = 10;
		}
		this.setSize(new Dimension(x1+1, y1+1));
		
			
	}
	
//	public void ballColl(Ball ball){
//		double 
//		if(ball.centre.x-7.5>=x&&ball.centre.x+7.5<=getSize().getWidth()){
//			if (){
//				ball.vy = - ball.vy+velo;
//				System.out.println("height");
//				ball.setLocation(ball.x, (int)getSize().getHeight());
//			} else if (ball.centre.y+7.5>=y&&ball.centre.y+7.5+10>=y+getSize().getHeight()){
//				ball.vy = - ball.vy+velo;
//				System.out.println("or not");
//				ball.setLocation(ball.x, y);
//			} else {}
//		}
//		if(ball.centre.y-7.5>=y&&ball.centre.y+7.5<=getSize().getHeight()){
//			if (ball.centre.x-7.5<=getSize().getWidth()){
//				ball.vx = - ball.vx+velo;
//				ball.setLocation((int)getSize().getWidth(), ball.y);
//			} else if (ball.centre.x+7.5>=x){
//				ball.vx = - ball.vx+velo;
//				ball.setLocation(x, ball.y);
//			} else {}
//		}
//		changeLength(250);
//	}
//	
	public void addAction2(HashMap<String, Bat> pressedKeys) {
		int i = pos;
		String a = "UP";
		String b = "DOWN";
		if (i == 1){
			a = "W";
			b = "S";
		} else if (i == 2){
			a = "I";
			b = "U";
		} else if (i == 4) {
			a = "RIGHT";
			b = "LEFT";
		}
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed "+a), "up");
		this.getActionMap().put("up", new moveAction(this, "pressed "+a, 1, pressedKeys));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed "+b), "down");
		this.getActionMap().put("down", new moveAction(this, "pressed "+b, 1, pressedKeys));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released "+a), "upno");
		this.getActionMap().put("upno", new moveAction(this, "pressed "+a, 0, pressedKeys));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released "+b), "downno");
		this.getActionMap().put("downno", new moveAction(this, "pressed "+b, 0, pressedKeys));
		
		
	}
	
	public void setLocation(int x, int y){
		super.setLocation(x, y);
		this.x = x;
		this.y = y;
	}
	
	public void changeLength(int leng){
		this.length = leng;
		int x1=-1;
		int y1=-1;
		if (pos == 1 || pos == 3) {
			x1 = 10;
			y1 = leng;
			if (this.y+leng>this.getParent().getWidth()){
				setLocation(this.x, this.getParent().getWidth()-leng);
			}
		} else if (pos == 2 || pos == 4) {
			x1 = leng;
			y1 = 10;
			if (this.x+leng>this.getParent().getHeight()){
				setLocation(this.getParent().getHeight()-leng, this.y);
			}
		}
		this.setSize(new Dimension(x1+1, y1+1));
		
	}
		
	
	public void drawThis(Graphics g) {
		if (pos == 1) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 10, length);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 10, length);
		} else if (pos == 2) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, length, 10);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, length, 10);
		} else if (pos == 3) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 10, length);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 10, length);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, length, 10);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, length, 10);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawThis(g);
	}
	
	@Override
	public Dimension getSize() {
		int x=-1,y=-1;
		if (pos == 1 || pos == 3) {
			x = 10;
			y = length;
		} else if (pos == 2 || pos == 4) {
			x = length;
			y = 10;
		}
		return new Dimension(x, y);
		
	}
	

	public Ball nearestball(){
		
		
		int[] abc= new int[balls.size()];
		
for(int k=0;k<balls.size();k++){
	Ball ball=balls.get(k);
	
int t=20000;
		int x=0;
		if(pos==4){
			
					
					int vx=(int)ball.vx;
					int vy=(int)ball.vy;
					if(vy>0){
					int bx=ball.x;
					int by=ball.y;
					if(vy!=0){
					 t=(600-by-10)/vy;
					}
					}
				}
		else{
			if(pos==2){
				int vx=(int)ball.vx;
				int vy=(int)ball.vy;
				if(vy<0){
				int bx=ball.x;
				int by=ball.y;
				if(vy!=0){
			    t=(10-by)/vy;
				}
				
				}
			}
			else{
				if(pos==3){
					

					int vx=(int)ball.vx;
					int vy=(int)ball.vy;
				if(vx>0){
					
					int bx=ball.x;
					int by=ball.y;
					if(vx!=0){
					t=(600-bx-10)/vx;
					x=by+t*vy;
					}}
					
					
					
				}
				
				else{
					if(pos==1){
						int vx=(int)ball.vx;
						int vy=(int)ball.vy;
						if(vx<0){
						int bx=ball.x;
						int by=ball.y;
						if(vx!=0){
					    t=(10-bx)/vx;
						}
						
						}
					}
					
					
					
				}
			}
		}
		
		abc[k]=t;
}

int q= min(abc);
	   return balls.get(q);
	   
   }
     


	
			
		
public int min(int[] abc){
	
	int i=0;
	int a=abc[0];
	
	
	
	for(int k=0; k<abc.length;k++){
		
		if(a>abc[k]){
			a= abc[k];
			i=k;
		}
		
	}
	return i;
	
	
	
}
	
	
	
		
	public int findx(){
		Ball ball= nearestball();
		
		int x=0;
if(pos==4){
	
			
			double vx=ball.vx;
			 double vy=ball.vy;
			int bx=ball.x;
			int by=ball.y;
			if(vy!=0){
			int t=(int)((600-by-10)/vy);
			x=(int)(bx+t*vx);
			}
		}
else{
	if(pos==2){
		int vx=(int)ball.vx;
		int vy=(int)ball.vy;
		int bx=ball.x;
		int by=ball.y;
		if(vy!=0){
		int t=by-10/vy;
		x=bx-t*vx;
		}
	}
	else{
		if(pos==3){
			

			int vx=(int)ball.vx;
			int vy=(int)ball.vy;
			int bx=ball.x;
			int by=ball.y;
			if(vx!=0){
			int t=(600-bx-10)/vx;
			x=by+t*vy;
			}
			
			
			
		}
		else{
			if(pos==1){
				int vx=(int)ball.vx;
				int vy=(int)ball.vy;
				int bx=ball.x;
				int by=ball.y;
				if(vx!=0){
				int t=(bx-10)/vx;
				x=by-t*vy;
				}
					
			}
			
			
			
		}
		
		
		
	}
	
	
	
	
	
}
return x;
		
		
		
		
		
		
		
		
	}
	
	public void toAI(){
		
		if(pos==4){
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
		else{
			if(pos==2){
				int a =bats.get(1).findx() ;
				int dis = a - bats.get(1).x - ((bats.get(1).length)/2 );
				System.out.println(a );
				//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
				if(dis>-10 && dis<10)
				{
					pressedKeys.remove("pressed U");
					pressedKeys.remove("pressed I");
				}
				else
				{
				
				if(a>bats.get(1).x + ((bats.get(1).length)/2)){
					System.out.println("qwweqw");
					pressedKeys.remove("pressed U");
					pressedKeys.put("pressed I",bats.get(1) );
				}	
				
				else{
					System.out.println("ssss");
					pressedKeys.remove("pressed I");
					pressedKeys.put("pressed U",bats.get(1) );
				}}
			
				
				
				
			}else{
				if(pos==3){
					int a =bats.get(2).findx() ;
					int dis = a - bats.get(2).y - ((bats.get(2).length)/2 );
					System.out.println(dis );
					//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
					if(dis>-5 && dis<5)
					{
						pressedKeys.remove("pressed DOWN");
						pressedKeys.remove("pressed UP");
					}
					else
					{
					
					if(dis>0){
						System.out.println("qwweqw");
						pressedKeys.remove("pressed UP");
						pressedKeys.put("pressed DOWN",bats.get(2) );
					}	
					
					else{
						System.out.println("ssss");
						pressedKeys.remove("pressed DOWN");
						pressedKeys.put("pressed UP",bats.get(2) );
					}}	
					
					
				}
				else{
					if(pos==1){
						int a =bats.get(0).findx() ;
						int dis = a - bats.get(0).y - ((bats.get(0).length)/2 );
						System.out.println(a );
						//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
						if(dis>-10 && dis<10)
						{
							pressedKeys.remove("pressed S");
							pressedKeys.remove("pressed W");
						}
						else
						{
						
						if(a>bats.get(0).y + ((bats.get(0).length)/2)){
							System.out.println("qwweqw");
							pressedKeys.remove("pressed W");
							pressedKeys.put("pressed S",bats.get(0) );
						}	
						
						else{
							System.out.println("ssss");
							pressedKeys.remove("pressed S");
							pressedKeys.put("pressed W",bats.get(0) );
						}}	
						
						
						
						
					}
					
					
					
				}
				
				
				
				
				
			}
			
			
			
			
			
			
		}
		
		
	}
	
	
	
	public void addAI(Ball ball, HashMap<String, Bat> pressedKeys) {
		int a1 = length/3;
		int b1 = (2*length)/3;
//		System.out.println(b1+""+a1);
		if (pos == 1){
			if (ball.vx !=0){
				double t = (ball.x)/((-1)*ball.vx);
				int projected = (int) (ball.y +ball.vy*t);
				if (projected>=y+10&&projected<=y+b1){
					pressedKeys.remove("pressed W");
					pressedKeys.remove("pressed S");
					velo = 0;
				} else if (projected<(y+a1)) {
					pressedKeys.remove("pressed S");
					pressedKeys.put("pressed W", this);
				} else if (projected>(y+b1)) {
					pressedKeys.remove("pressed W");
					pressedKeys.put("pressed S", this);
				}
			}
		} else if (pos == 3){
			if (ball.vx !=0){
				double t = (getParent().getWidth()-ball.x)/ball.vx;
				int projected = (int) (ball.y +ball.vy*t);
				if (projected>=y+10&&projected<=y+b1){
					pressedKeys.remove("pressed UP");
					pressedKeys.remove("pressed DOWN");
					velo = 0;
				} else if (projected<(y+a1)) {
					pressedKeys.remove("pressed DOWN");
					pressedKeys.put("pressed UP", this);
				} else if (projected>(y+b1)) {
					pressedKeys.remove("pressed UP");
					pressedKeys.put("pressed DOWN", this);
				}
			}
		} else if (pos == 2){
			if (ball.vy !=0){
				double t = ball.y/((-1)*ball.vy);
				int projected = (int) (ball.x +ball.vx*t);
//				System.out.println(t+", "+projected);
				if (projected>=x+a1&&projected<=x+b1){
					pressedKeys.remove("pressed I");
					pressedKeys.remove("pressed U");
					velo = 0;
//					System.out.println("ai released"+pressedKeys.size());
				} else if (projected>(x+b1)) {
					pressedKeys.remove("pressed U");
					pressedKeys.put("pressed I", this);
//					System.out.println("Up"+pressedKeys.size());
				} else if (projected<(x+a1)) {
					pressedKeys.remove("pressed I");
					pressedKeys.put("pressed U", this);
//					System.out.println("Down"+pressedKeys.size());
				}
			}
		} else if (pos == 4){
			if (ball.vy !=0){
				double t = (getParent().getHeight()-ball.y)/(ball.vy);
				int projected = (int) (ball.x +ball.vx*t);
//				System.out.println(t+", "+projected);
				if (projected>=x+a1&&projected<=x+b1){
					pressedKeys.remove("pressed RIGHT");
					pressedKeys.remove("pressed LEFT");
					velo = 0;
//					System.out.println("ai released"+pressedKeys.size());
				} else if (projected>(x+b1)) {
					pressedKeys.remove("pressed LEFT");
					pressedKeys.put("pressed RIGHT", this);
//					System.out.println("Up"+pressedKeys.size());
				} else if (projected<(x+a1)) {
					pressedKeys.remove("pressed RIGHT");
					pressedKeys.put("pressed LEFT", this);
//					System.out.println("Down"+pressedKeys.size());
				}
			}
		}
	}
}
