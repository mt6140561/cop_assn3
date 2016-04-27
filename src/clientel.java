
import java.io.IOException;import java.io.*;
 
import java.net.*;
public class clientel {
	public static void main(String args[]) throws UnknownHostException, IOException{
		Socket c=new Socket("192.168.56.59", 1000);
		DataOutputStream o=new DataOutputStream(c.getOutputStream());
		o.writeUTF("connected Rishabh");
		DataInputStream i=new DataInputStream(c.getInputStream());
		System.out.println(i.readUTF());
		c.close();
	}
}