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

	public HashMap<String, Bat> pressedKeys;//keys pressed in the container
	public ArrayList<Ball> balls;//balls in the game

	public boolean Stonewall = false;//whether it has stonewall
	
	/*
	 * Bat(x, y, l, c, p): 	creates at x, y with l length, c lives and p position on screen
	 * ballBat():			defines physics of collision of bat with ball
	 * addAction2():		Adds action to the bat
	 * changeLength():		Changes length of bat
	 * nearestball():		gives ball which will take least time to reach bats wall
	 * findx():				projected point where the ball will strike the wall
	 * toAI():				adds AI to bat
	 */
	public Bat (int x, int y, int length, int counter, int pos) {
		this.x = x;//x coordinate
		this.y = y;//y coordinate
		this.length = length;//length of bat
		this.counter = 10;//life
		this.pos = pos;//positon in container
		this.velo = 0;//velocity
		this.move = 8;//movement speed
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
	
	public boolean isBetween(double x, double start, double range){
		return (x>=start&&x<=start+range);
	}
	
	public void ballBat(Ball ball){
		
		switch (pos){
		case 1:
			if (isBetween(ball.centre.y, y,length)&&ball.centre.x<=x+10+7.5){
				ball.vx = -ball.vx;
				ball.vy = ball.vy-(velo);
				ball.setLocation(x+10, ball.y);
			} else if (isBetween(ball.x, x, 10)){
				if (isBetween(ball.centre.y+7.5, y, length/2)){
					ball.setLocation(ball.x, y-15);
					ball.vy = -ball.vy;
					if (ball.vy<ball.vy+velo){
						ball.vy = ball.vy+velo;
					}
				} else if (isBetween(ball.centre.y+7.5, y+(length/2), length/2)){
					ball.setLocation(ball.x, y+length);
					ball.vy = -ball.vy;
					if (ball.vy<ball.vy+velo){
						ball.vy = ball.vy+velo;
					}
				} else {}
			}
			break;
		
		case 2:
			if ((isBetween(ball.centre.x, x, length)&&ball.centre.y<=y+10+7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(velo);
				ball.setLocation(ball.x, y+10);
			} else if (isBetween(ball.y, y, 10)){
				if (isBetween(ball.centre.x+7.5, x, length/2)){
					ball.setLocation(x-15, ball.y);
					ball.vx = -ball.vx;
					if (ball.vx<ball.vx+velo){
						ball.vx = ball.vx+velo;
					}
				} else if (isBetween(ball.centre.x+7.5, x+(length/2), length/2)){
					ball.setLocation(x+length, ball.y);
					ball.vx = -ball.vx;
					if (ball.vx<ball.vx+velo){
						ball.vx = ball.vx+velo;
					}
				} else {}
			}
			break;
			
		case 3:
			if ((isBetween(ball.centre.y, y, length)&&ball.centre.x>=x-7.5)){
				ball.vx = -ball.vx;
				ball.vy = ball.vy-(velo);
				ball.setLocation(x-15, ball.y);
			} else if (isBetween(ball.x, x, 10)){
				if (isBetween(ball.centre.y+7.5, y, length/2)){
					ball.setLocation(ball.x, y-15);
					ball.vy = -ball.vy;
					if (ball.vy<ball.vy+velo){
						ball.vy = ball.vy+velo;
					}
				} else if (isBetween(ball.centre.y+7.5, y+(length/2), length/2)){
					ball.setLocation(ball.x, y+length);
					ball.vy = -ball.vy;
					if (ball.vy<ball.vy+velo){
						ball.vy = ball.vy+velo;
					}
				} else {}
			}
			break;
			
		case 4:
			if ((isBetween(ball.centre.x, x,length)&&ball.centre.y>=y-7.5)){
				ball.vy = -ball.vy;
				ball.vx = ball.vx+(velo);
				ball.setLocation(ball.x, y-15);
			} else if (isBetween(ball.y, y, 10)){
				if (isBetween(ball.centre.x+7.5, x, length/2)){
					ball.setLocation(x-15, ball.y);
					ball.vx = -ball.vx;
					if (ball.vx<ball.vx+velo){
						ball.vx = ball.vx+velo;
					}
				} else if (isBetween(ball.centre.x+7.5, x+(length/2), length/2)){
					ball.setLocation(x+length, ball.y);
					ball.vx = -ball.vx;
					if (ball.vx<ball.vx+velo){
						ball.vx = ball.vx+velo;
					}
				} else {}
			}
		}
	}
	
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
	
int t=20000000;
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
				//int vx=(int)ball.vx;
				double vy=ball.vy;
				if(vy<0){
				//int bx=ball.x;
				int by=ball.y;
				if(vy!=0){
			    t=(int)((10-by)/vy);
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
		int t=(by-10)/vy;
		x=bx-t*vx;
		System.out.println(x);
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
		this.move=4;
		if(pos==4){
			int a =findx() ;
			int dis = a - x - ((length)/2 );
			System.out.println(a );
			//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
			if(dis>-10 && dis<10)
			{
				pressedKeys.remove("pressed LEFT");
				pressedKeys.remove("pressed RIGHT");
			}
			else
			{
			
			if(a>x + ((length)/2)){
				System.out.println("qwweqw");
				pressedKeys.remove("pressed LEFT");
				pressedKeys.put("pressed RIGHT",this );
			}	
			
			else{
				System.out.println("ssss");
				pressedKeys.remove("pressed RIGHT");
				pressedKeys.put("pressed LEFT",this );
			}}
		
		}
		else{
			if(pos==2){
				int a =findx() ;
				int dis = a - x - ((length)/2 );
				System.out.println(a +"  ");
				//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
				if(dis>-10 && dis<10)
				{
					pressedKeys.remove("pressed U");
					pressedKeys.remove("pressed I");
				}
				else
				{
				
				if(a>x + ((length)/2)){
					System.out.println("qwweqw");
					pressedKeys.remove("pressed U");
					pressedKeys.put("pressed I",this );
				}	
				
				else{
					System.out.println("ssss");
					pressedKeys.remove("pressed I");
					pressedKeys.put("pressed U",this );
				}}
			
				
				
				
			}else{
				if(pos==3){
					int a =findx() ;
					int dis = a - y - ((length)/2 );
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
						pressedKeys.put("pressed DOWN",this );
					}	
					
					else{
						System.out.println("ssss");
						pressedKeys.remove("pressed DOWN");
						pressedKeys.put("pressed UP",this );
					}}	
					
					
				}
				else{
					if(pos==1){
						int a =findx() ;
						int dis = a - y - ((length)/2 );
						System.out.println(a );
						//if(a>bats.get(3).x + ((bats.get(3).length)/2) + 100 && a<bats.get(3).x + ((bats.get(3).length)/2)-100)
						if(dis>-10 && dis<10)
						{
							pressedKeys.remove("pressed S");
							pressedKeys.remove("pressed W");
						}
						else
						{
						
						if(a>y + ((length)/2)){
							System.out.println("qwweqw");
							pressedKeys.remove("pressed W");
							pressedKeys.put("pressed S",this);
						}	
						
						else{
							System.out.println("ssss");
							pressedKeys.remove("pressed S");
							pressedKeys.put("pressed W",this );
						}
						}		
					}	
				}	
			}	
		}	
	}
}
