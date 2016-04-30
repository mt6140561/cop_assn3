import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class instructions extends JFrame {

	private JPanel contentPane;
	private JTextField txtInstructions;
	private TextArea textArea_1;
	private TextArea textArea_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructions frame = new instructions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public instructions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600,600);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setFocusCycleRoot(true);
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInstructions = new JTextField();
		txtInstructions.setToolTipText("BACK");
		txtInstructions.setEditable(false);
		txtInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstructions.setText("INSTRUCTIONS");
		txtInstructions.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtInstructions.setBounds(170, 11, 259, 49);
		contentPane.add(txtInstructions);
		txtInstructions.setColumns(10);
		
		TextArea textArea = new TextArea("hello",10,325,TextArea.SCROLLBARS_NONE);
		textArea.setText("To play a multi player game , if you want to play on the same machine just select the play on single machine button and choose your own conditions.If you want to play a multiplayer game choose play on the diiferent machines and then you will be able to see a two player button clicking on that will lead to a frame with two buttons create server and join game the one who clicks the server can select no of balls from the top and the person who will click on join game had to enter the ip of the player's computer who created the server");
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textArea.append("");
		textArea.setEditable(false);
		
		textArea.setBounds(10, 335, 564, 226);
		contentPane.add(textArea);
		
		textArea_1 = new TextArea("SUPERPOWERS will appear randomly in the between the game.YELLOW colored  call will denote STONEWALL that will not decrease the power when the ball is left.PINK colored ball will give an extra life to the player.GREEN coloured ball will increase the bat length . BLACK coloured ball is a negative power and will decrease the bat spped.Losing the ball once will lead to cancelation of all the powers\r\n", 10, 325, TextArea.SCROLLBARS_NONE);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 166, 564, 163);
		contentPane.add(textArea_1);
		
		textArea_2 = new TextArea("For games on same machine . W and S will control the player on the left .UP and DOWN will control the player on the right.RIGHT AND LEFT will control the player on the left. U and I will control the player on the top.", 10, 325, TextArea.SCROLLBARS_NONE);
		textArea_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 66, 564, 94);
		contentPane.add(textArea_2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstframe abcd = new firstframe();
				String[] a ={};
				abcd.setVisible(false);
				
				abcd.main(a);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 49);
		contentPane.add(btnNewButton);
	}
}
