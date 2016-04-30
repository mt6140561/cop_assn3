import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class firstframe extends JFrame {

	private JPanel contentPane;
	private JTextField txtPingPongGame;

	static firstframe frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new firstframe();
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
	public firstframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Play on same machine");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			onclickingsinglemachine abc = new onclickingsinglemachine();
			String[] a={};
			frame.setVisible(false);
			abc.main(a);
			}
		});
		btnNewButton.setBounds(118, 110, 353, 84);
		panel.add(btnNewButton);
		
		txtPingPongGame = new JTextField();
		txtPingPongGame.setEditable(false);
		txtPingPongGame.setOpaque(false);
		txtPingPongGame.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtPingPongGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtPingPongGame.setText("Ping Pong Game");
		txtPingPongGame.setBounds(10, 11, 554, 74);
		panel.add(txtPingPongGame);
		txtPingPongGame.setColumns(10);
		
		JButton btnPlayOnDifferent = new JButton("Play on different machines");
		btnPlayOnDifferent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPlayOnDifferent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] q={};
			playondifferentmachines ab = new playondifferentmachines();
			frame.setVisible(false);
			ab.main(q);
			}
		});
		btnPlayOnDifferent.setBounds(118, 240, 353, 84);
		panel.add(btnPlayOnDifferent);
		
		JButton btnInstructionsForNew = new JButton("Instructions for new user");
		btnInstructionsForNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] q={};
				instructions ab = new instructions();
				frame.setVisible(false);
				ab.main(q);
			}
		});
		btnInstructionsForNew.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnInstructionsForNew.setBounds(118, 375, 353, 84);
		panel.add(btnInstructionsForNew);
	}
}
