import java.net.*;
import java.io.*;
public class client  {
	public static void main(String[] args)throws IOException{
		Socket s=new Socket("192.168.56.59", 55);
		
		DataInputStream in= new DataInputStream(s.getInputStream());
		
		System.out.println(in.readUTF());
		s.close();
	}
}