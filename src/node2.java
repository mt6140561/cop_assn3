import javax.swing.JFrame;

public class node2 {
	public static void main(String[] args){
		p2pNode two = new p2pNode(62);
		two.name = "chap";
		two.connect("localHost", 89);
		
//		two.run();
//		one.tm.start();
		JFrame fr = new JFrame();
		fr.setVisible(false);
	}
}
