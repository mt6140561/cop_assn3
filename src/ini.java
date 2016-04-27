import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;

public class ini extends JFrame {

	private JPanel contentPane;
	private JTextField txtPingPongGame;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnStartSinglePlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ini frame = new ini();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public ini() {
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtPingPongGame = new JTextField();
		txtPingPongGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtPingPongGame.setSize(new Dimension(5, 5));
		txtPingPongGame.setDisabledTextColor(Color.RED);
		txtPingPongGame.setText("PING PONG GAME");
		txtPingPongGame.setFont(new Font("Arial", Font.BOLD, 39));
		contentPane.add(txtPingPongGame, BorderLayout.NORTH);
		txtPingPongGame.setColumns(10);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		btnNewButton_1 = new JButton("MULTIPLAYER GAME");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 74, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, -427, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 127, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -173, SpringLayout.EAST, panel);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			multi abc = new multi();
			String[] args ={};
			abc.main(args);
			
			}
		});
	//	btnNewButton_1.se
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(btnNewButton_1);
		
		btnStartSinglePlayer = new JButton("START SINGLE PLAYER");
		sl_panel.putConstraint(SpringLayout.NORTH, btnStartSinglePlayer, 33, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnStartSinglePlayer, 0, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnStartSinglePlayer, -287, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnStartSinglePlayer, 0, SpringLayout.EAST, btnNewButton_1);
		btnStartSinglePlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStartSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Contains abc = new Contains();
				String[] args ={};
				abc.main(args);
				
			}
		});
		panel.add(btnStartSinglePlayer);
	}
}
