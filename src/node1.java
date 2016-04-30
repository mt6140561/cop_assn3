import javax.swing.JFrame;

public class node1 {
	public static void main(String[] args){
		p2pNode two = new p2pNode(89);
		two.name = "chap";
		two.connect("localHost", 22);
//		two.bridge();
//		two.run();
//		one.tm.start();
		JFrame fr = new JFrame();
		fr.setVisible(false);
	}
}
