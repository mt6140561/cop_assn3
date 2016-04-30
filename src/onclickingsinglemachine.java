import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class onclickingsinglemachine extends JFrame {

	private JPanel contentPane;
	static onclickingsinglemachine frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new onclickingsinglemachine();
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
	
	int balls=1;
	
	
	
	public onclickingsinglemachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("No of Players  = 1");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
			String[] a = {};
			abc();
			Contains anc = new Contains(4,balls);
			
			try {
				frame.setVisible(false);
				anc.main(a);}
			
			
			catch(Exception p){
				
			}
			}
		});
		btnNewButton.setBounds(105, 93, 391, 81);
		contentPane.add(btnNewButton);
		
		JButton btnNoOfPlayers = new JButton("No of Players = 2");
		btnNoOfPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				String[] a = {};
				abc();
				Contains2 anc = new Contains2(4,balls);
				
				try {
					frame.setVisible(false);
					anc.main(a);}
				
				
				catch(Exception p){
					
				}
				
				
			}
		});
		btnNoOfPlayers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoOfPlayers.setBounds(105, 209, 391, 81);
		contentPane.add(btnNoOfPlayers);
		
		JButton btnNoOfPlayers_1 = new JButton("No of Players = 3");
		btnNoOfPlayers_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoOfPlayers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				String[] a = {};
				abc();
				Contains3 anc = new Contains3(4,balls);
				
				try {
					frame.setVisible(false);
					anc.main(a);}
				
				
				catch(Exception p){
					
				}
			
			
			}
		});
		btnNoOfPlayers_1.setBounds(105, 322, 391, 81);
		contentPane.add(btnNoOfPlayers_1);
		
		JButton btnNoOfPlayers_2 = new JButton("No. of Players = 4");
		btnNoOfPlayers_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoOfPlayers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		

				String[] a = {};
				abc();
				Contains4 anc = new Contains4(4,balls);
				
				try {
					
					frame.setVisible(false);
					anc.main(a);}
				
				
				catch(Exception p){
					
				}
			}
		});
		btnNoOfPlayers_2.setBounds(105, 434, 391, 81);
		contentPane.add(btnNoOfPlayers_2);
		
		 chckbxmntmNewCheckItem = new JCheckBoxMenuItem("1");
		chckbxmntmNewCheckItem.setBounds(272, 47, 49, 22);
		contentPane.add(chckbxmntmNewCheckItem);
		
		 checkBoxMenuItem = new JCheckBoxMenuItem("2");
		checkBoxMenuItem.setBounds(346, 47, 49, 22);
		contentPane.add(checkBoxMenuItem);
		
		 checkBoxMenuItem_1 = new JCheckBoxMenuItem("3");
		checkBoxMenuItem_1.setBounds(418, 47, 49, 22);
		contentPane.add(checkBoxMenuItem_1);
		
        
		JTextArea txtrSelectNoOf = new JTextArea();
		txtrSelectNoOf.setEditable(false);
		txtrSelectNoOf.setText("Select No of balls");
		txtrSelectNoOf.setBounds(105, 47, 157, 22);
		contentPane.add(txtrSelectNoOf);
		
		Button button = new Button("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			firstframe abcd = new firstframe();
			String[] a ={};
			frame.setVisible(false);
			
			abcd.main(a);
			
			}
		});
		button.setBounds(10, 10, 70, 47);
		contentPane.add(button);
		
		txtuserWillBe = new JTextField();
	
		txtuserWillBe.setEditable(false);
		txtuserWillBe.setText("(user will be on the bottom)");
		txtuserWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		txtuserWillBe.setOpaque(false);
		txtuserWillBe.setBounds(105, 178, 391, 20);
		contentPane.add(txtuserWillBe);
		txtuserWillBe.setColumns(10);
		
		txtusersWillBe = new JTextField();
		txtusersWillBe.setText("(users will be on left and right sides)");
		txtusersWillBe.setOpaque(false);
		txtusersWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		txtusersWillBe.setEditable(false);
		txtusersWillBe.setColumns(10);
		txtusersWillBe.setBounds(105, 291, 391, 20);
		contentPane.add(txtusersWillBe);
		
		txtaiWillBe = new JTextField();
		txtaiWillBe.setText("(AI will be just on the top)");
		txtaiWillBe.setOpaque(false);
		txtaiWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		txtaiWillBe.setEditable(false);
		txtaiWillBe.setColumns(10);
		txtaiWillBe.setBounds(105, 403, 391, 20);
		contentPane.add(txtaiWillBe);
		
		txthahaha = new JTextField();
		txthahaha.setText("(HAHAHA)");
		txthahaha.setOpaque(false);
		txthahaha.setHorizontalAlignment(SwingConstants.CENTER);
		txthahaha.setEditable(false);
		txthahaha.setColumns(10);
		txthahaha.setBounds(105, 518, 391, 20);
		contentPane.add(txthahaha);
	}
	JCheckBoxMenuItem checkBoxMenuItem_1;
	JCheckBoxMenuItem checkBoxMenuItem;
	JCheckBoxMenuItem chckbxmntmNewCheckItem;
	private JTextField txtuserWillBe;
	private JTextField txtusersWillBe;
	private JTextField txtaiWillBe;
	private JTextField txthahaha;
	public void abc(){
		if(checkBoxMenuItem_1.getState()){
			balls=3;
		}
        else{
        	if(checkBoxMenuItem.getState()){
    			balls=2;
    		}
        	else{
        		balls=1;
        	}
        	
        	
        }
		
	}
}
