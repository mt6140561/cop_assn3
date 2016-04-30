import javax.swing.JFrame;

public class node3 {
	public static void main(String[] args){
		p2pNode two = new p2pNode(49);
		two.name = "chap";
		two.connect("localHost", 22);
		
//		two.run();
//		one.tm.start();
		JFrame fr = new JFrame();
		fr.setVisible(false);
	}
}
