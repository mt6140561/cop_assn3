import java.net.*;
import java.io.*;
public class server {
	ServerSocket serv;
	public static boolean f,c1=false,c2=false,c3=false;
	Socket ser1,ser2,ser3,client1,client2,client3;
	int port=0;
	public server(int p,String d)throws IOException{
		Socket client1= new Socket (d,p);
		DataInputStream i= new DataInputStream(client1.getInputStream());
		String inp=i.readUTF();
		
		
		
		if(inp.equals("1")){
		port=p+1;
		serv= new ServerSocket(port);
		serv.setSoTimeout(10000);
		ser1=serv.accept();
		ser2=serv.accept();
		ser3=serv.accept();
		if(ser1!=null){
			c1=true;
		}
		if(ser2!=null){
			c2=true;
			client2=new Socket("h",p+2);
		}
		if(ser3!=null){
			c3=true;
			client3=new Socket("g",p+3);
		}
		
		
		
		
	}
		if(inp.equals("2")){
			port=p+2;
			serv= new ServerSocket(port);
			serv.setSoTimeout(10000);
			ser1=serv.accept();
			ser2=serv.accept();
			ser3=serv.accept();
			if(ser1!=null){
				c1=true;
			}
			if(ser2!=null){
				c2=true;
				client2=new Socket("h",p+1);
			}
			if(ser3!=null){
				c3=true;
				client3=new Socket("g",p+3);
			}
			
			
			
			
		}
		if(inp.equals("3")){
			port=p+3;
			serv= new ServerSocket(port);
			serv.setSoTimeout(10000);
			ser1=serv.accept();
			ser2=serv.accept();
			ser3=serv.accept();
			if(ser1!=null){
				c1=true;
				
			}
			if(ser2!=null){
				c2=true;
				client2=new Socket("h",p+1);
			}
			if(ser3!=null){
				c3=true;
				client3=new Socket("g",p+2);
			}
			
			
			
			
		}
	}
	public server(int p)throws IOException{
		
			port=p;
			serv= new ServerSocket(port);
			serv.setSoTimeout(10000);
			ser1=serv.accept();
			ser2=serv.accept();
			ser3=serv.accept();
			if(ser1!=null){
				c1=true;
				client1=new Socket(ser1.getInetAddress(),p+1);
				DataOutputStream out1= new DataOutputStream(ser1.getOutputStream());
				out1.writeUTF("1");
				
			}
			if(ser2!=null){
				c2=true;
				client2=new Socket(ser2.getInetAddress(),p+2);
				DataOutputStream out1= new DataOutputStream(ser1.getOutputStream());
				out1.writeUTF("2");
			}
			if(ser3!=null){
				c3=true;
				client3=new Socket(ser3.getInetAddress(),p+3);
				DataOutputStream out1= new DataOutputStream(ser1.getOutputStream());
				out1.writeUTF("3");
			}
			
			
			
			
		
	}
	public void send(String s)throws IOException{
		if(c1==true){
			DataOutputStream out1= new DataOutputStream(ser1.getOutputStream());
			out1.writeUTF(s);
		}
		if(c2==true){
			DataOutputStream out1= new DataOutputStream(ser2.getOutputStream());
			out1.writeUTF(s);
		}
		if(c3==true){
			DataOutputStream out1= new DataOutputStream(ser3.getOutputStream());
			out1.writeUTF(s);
		}
	}
	public String[] recieve()throws IOException{
		String[] a = new String[3];
		if(c1==true){
			DataInputStream in= new DataInputStream(client1.getInputStream());
			a[0]=in.readUTF();
			
		}
		
		if(c2==true){
			DataInputStream in= new DataInputStream(client2.getInputStream());
			a[1]=in.readUTF();
		}
		if(c3==true){
			DataInputStream in= new DataInputStream(client3.getInputStream());
			a[2]=in.readUTF();
			
		}
		return a;
	}
	public String[][] decipher(String s){
		int n=4;
		String[][] sa = new String[n][];
		String d[]=s.split(";");
		for(int i=0;i<n;i++){
			String g[]=d[i].split("\\s+");
			if(g[0].equals("batposition")){
				sa[0]=g;
			}
			if(g[0].equals("length")){
				sa[1]=g;
			}
			if(g[0].equals("life")){
				sa[2]=g;
			}
			if(g[0].equals("ballposition")){
				sa[3]=g;
			}
		}
		return sa;
	}
	public String Cipher(int batx,int baty, int length, int counter){
		String s="batposition "+batx+" "+baty+";length "+length+";life "+counter;
		return s;
	}
	public String Cipherserv(int batx,int baty, int length, int counter,int ballx, int bally){
		String s="batposition "+batx+" "+baty+";length "+length+";life "+counter+";ballposition "+ballx+" "+bally;
		return s;
	}
	public void close()throws IOException{
		serv.close();
		ser1.close();
		ser2.close();
		ser3.close();
		client1.close();
		client2.close();
		client3.close();
		
	}
}