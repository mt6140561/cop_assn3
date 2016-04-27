import java.awt.*;
import javax.swing.*;


public class initial extends JFrame {
 
	JLabel l1= new JLabel();
	JLabel l2= new JLabel();
	JPanel p1= new JPanel();
	JLabel l3= new JLabel();
	JLabel l4= new JLabel();
	JLabel l5= new JLabel();
	JPanel p2= new JPanel();
	JButton b1= new JButton();
	JButton b2= new JButton();
	
	
	
	
	
	
    public static void main(String[] args) {
       initial frame = new initial();
//   //     frame.create();
        frame.setSize(600, 600);
//        JPanel p1 = new JPanel();
//        JButton b1 = new JButton();
//        b1.setBounds(100, 100, 20, 20);
//        p1.add(b1);
//        
//        frame.getContentPane().add(p1);
           frame.abc();
   frame.setVisible(true);;
    }
 
    
    
    Container c = getContentPane();
    
    public initial(){
    	
    	
//    	l1.setText("");
//    	//l1.setText("sadsadsadsa");
//    	l1.setBounds(200, 200,200,200);
//    	
    
    }
    
    public void abc(){
    	setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    	l1.setText("PING PONG GAME");
    	p1.add(l1,BorderLayout.NORTH);
        b2.setText("Multiplayer game");
        p1.add(b2, BorderLayout.SOUTH);
    	c.add(p1,BorderLayout.NORTH);	
        
    b1.setText("SINGLE PLAYER");
    l2.setText("             ");
    l2.setFont(new Font("Arial",Font.ITALIC,150));
    p2.add(b1,BorderLayout.NORTH);
    p2.add(l2,BorderLayout.SOUTH);
    c.add(p2,BorderLayout.SOUTH);	
    b1.addActionListener( new Action1());
      
    }
    static class Action1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        }
    
    public void create(){
    	 Container c = getContentPane();

         JPanel p1 = new JPanel();
         JButton b1 = new JButton();
         b1.setBounds(100, 100, 200, 200);
         p1.add(b1);
         
         c.add(p1);
         c.setSize(600, 600);
         pack();
         setVisible(true);
   	 
    }
    

}