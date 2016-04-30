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
import java.awt.Color;
import java.awt.TextArea;

public class twoplayermulti extends JFrame {
	static twoplayermulti frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new twoplayermulti();
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
	
	
	
	public twoplayermulti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Server");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
			

				String[] a = {};
				String qwe=getip();
				abc();
				
				try {
					
			twoplayerserver abc=new twoplayerserver(4,balls);	
			frame.setVisible(false);	
				abc.run();
					
			
				
				}
			catch(Exception p){
				
			}
			}
		});
		btnNewButton.setBounds(105, 183, 391, 81);
		contentPane.add(btnNewButton);
		
		JButton btnNoOfPlayers = new JButton("Join Server");
		btnNoOfPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				String[] a = {};
			
				String qwe=getip();
				
				System.out.println("1"+qwe);
				try {
					
			 if(qwe.equals(null)==false){
				 abc();
				twoplayerclient ab=new twoplayerclient(4,1,getip());	
			//	ab.IP=qwe;
				ab.run();
				System.out.println(qwe);
			
				
				System.out.println("a"+ab.IP+"b");		
			 
			 
			 }
				
				}
				catch(Exception p){
					
				}
				
				
			}
		});
		btnNoOfPlayers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoOfPlayers.setBounds(105, 311, 391, 81);
		contentPane.add(btnNoOfPlayers);
		
		 chckbxmntmNewCheckItem = new JCheckBoxMenuItem("1");
		chckbxmntmNewCheckItem.setBounds(272, 47, 49, 22);
		contentPane.add(chckbxmntmNewCheckItem);
		
		 checkBoxMenuItem = new JCheckBoxMenuItem("2");
		checkBoxMenuItem.setBounds(346, 47, 49, 22);
		contentPane.add(checkBoxMenuItem);
		
		 checkBoxMenuItem_1 = new JCheckBoxMenuItem("3");
		checkBoxMenuItem_1.setBounds(418, 47, 49, 22);
		contentPane.add(checkBoxMenuItem_1);
		
        
		 txtrSelectNoOf = new JTextArea();
		 txtrSelectNoOf.setOpaque(false);
		txtrSelectNoOf.setEditable(false);
		txtrSelectNoOf.setText("Select No of balls");
		txtrSelectNoOf.setBounds(105, 66, 157, 22);
		contentPane.add(txtrSelectNoOf);
		
		 textArea = new JTextArea();
		textArea.setBounds(184, 99, 216, 22);
		contentPane.add(textArea);
		
		 txtrTypeYourIp = new JTextArea();
		 txtrTypeYourIp.setFocusTraversalPolicyProvider(true);
		 txtrTypeYourIp.setFocusCycleRoot(true);
		 txtrTypeYourIp.setDisabledTextColor(Color.BLACK);
		 txtrTypeYourIp.setEditable(false);
		txtrTypeYourIp.setOpaque(false);
		txtrTypeYourIp.setText("Type your IP before creating server");
		txtrTypeYourIp.setBounds(194, 132, 316, 22);
		contentPane.add(txtrTypeYourIp);
		
		button = new Button("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playondifferentmachines abcd = new playondifferentmachines();
				String[] a ={};
				frame.setVisible(false);
				
				abcd.main(a);
			}
		});
		button.setBounds(10, 10, 70, 49);
		contentPane.add(button);
		
		textArea_1 = new TextArea("",10,451,TextArea.SCROLLBARS_NONE);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textArea_1.setText("The person creating the server will be on the right and the one joining it will be on the left");
		textArea_1.setBounds(10, 487, 564, 64);
	 textArea_1.isOpaque();
		contentPane.add(textArea_1);
	}
	JTextArea txtrSelectNoOf;
	JTextArea txtrTypeYourIp;
	JTextArea textArea;
	JCheckBoxMenuItem checkBoxMenuItem_1;
	JCheckBoxMenuItem checkBoxMenuItem;
	JCheckBoxMenuItem chckbxmntmNewCheckItem;
	private Button button;
	private TextArea textArea_1;
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
	
	public String getip(){
		String a= textArea.getText();
return a;
	}
}
