import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.Timer;

public class p2pNode implements ActionListener{
	public ServerSocket server;
	public Socket[] client = new Socket[6];
	public String[] your = new String[3];
	public int sockets = 0;
	public String name = "";
	public int port;
	public int[] ports = new int[3];
    Timer tm;
	public p2pNode(int port){
		 this.port = port;
		 tm = new Timer(5, this);
		 try {
			server = new ServerSocket(port);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 tm.start();
	}
	
	public void bridge(){
		for (int i = 0; i<3; i++){
			if (your[i]!=null&&your[i].equals("false")){
				try {
					client[i] = new Socket(client[i].getInetAddress().getHostName(), ports[i]);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {	
					e.printStackTrace();
				}
			}
		}
	}
	
	public void connect(String ip, int port){
		try {
			client[sockets] = new Socket(ip, port);
			ports[sockets] = port;
			your[sockets] = "true";
			int ie = this.port;
			System.out.println(client[sockets]);
			DataOutputStream newconn = new DataOutputStream(client[sockets].getOutputStream());
			newconn.writeInt(ie);
			DataInputStream moreconn = new DataInputStream(client[sockets].getInputStream());
			String more = moreconn.readUTF();
//			System.out.println(more);
			String[] iports = more.split("\\s+");
			sockets = sockets+1;
			for(int i=1; i<iports.length; i++){
//				System.out.println(iports[i]);
				boolean present = false;
				for(int j = 0; j<sockets; j++){
//					System.out.println(iports[i]+"=="+client[j].getInetAddress().getHostAddress()+";"+ports[j]);
//					System.out.println(iports[i]+"out");
					if (iports[i].equals(client[j].getInetAddress().getHostAddress()+";"+ports[j])){
//						System.out.println(true+" "+j);
						present = true;
					}
				}
				if (present == false){
//					System.out.println(iports[i]+" 1");
					String[] info = iports[i].split(";");
					connect(info[0], Integer.parseInt(info[1]));
				}
			}
			
//			for (int i=0; )
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println(sockets);
//		System.out.println("hi");
		if (sockets<3){
			try {
				client[sockets] = server.accept();

				DataInputStream newconn = new DataInputStream(client[sockets].getInputStream());
				int port = (newconn.readInt());
				ports[sockets] = port;
				DataOutputStream moreconn = new DataOutputStream(client[sockets].getOutputStream());
				String s = "ips ";
				for(int i=0; i<sockets; i++){
					s = s+client[i].getInetAddress().getHostAddress()+";"+ports[i]+" ";
				}
				moreconn.writeUTF(s);
				//aur implementation karni hai, multiple server nahi kiya hai
				System.out.println(client[sockets]);
				your[sockets] = "false";
 				sockets = sockets+1;
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}