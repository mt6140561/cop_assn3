import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class multi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					multi frame = new multi();
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
	public multi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,600,600);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 600, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_10129219229400");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("2 player");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				Contains2 abc = new Contains2();
				
				String[] args = {};
						abc.main(args);
				
			}
		});
		btnNewButton.setBounds(158, 67, 292, 107);
		panel.add(btnNewButton);
		
		JButton btnPlayer = new JButton("3 player");
		btnPlayer.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnPlayer.setBounds(158, 202, 292, 107);
		panel.add(btnPlayer);
		
		
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Contains3 abc = new Contains3();
				
				String[] args = {};
						abc.main(args);
				
			}
		});
		JButton btnPlayer_1 = new JButton("4 player");
		btnPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnPlayer_1.setBounds(158, 346, 292, 107);
		panel.add(btnPlayer_1);
		btnPlayer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Contains4 abc = new Contains4();
				
				String[] args = {};
						abc.main(args);
				
			}
		});
		
		
	}

}
