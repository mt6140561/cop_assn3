
import java.io.IOException;
import java.net.*;
public class Server {
	public static int count=3;
	public static void main(String [] args) throws IOException{
		ServerSocket serv=new ServerSocket(1000);Socket s,s1,s2;ServerThread st,st1,st2;
		
		serverexe e,e1,e2;
		try{
			s=serv.accept();
			st=new ServerThread(s);
			System.out.print(1);
			e=new serverexe(st,s);
			System.out.print(12);
			e.run();
			System.out.print(3);
		}
		catch(Exception r1)
		{
			count--;
		}
		try{
			System.out.print(5334);
			s1=serv.accept();
			st1=new ServerThread(s1);
			e1=new serverexe(st1,s1);
			e1.run();
		}
		catch(Exception r)
		{
			count--;
		}
		try{
			s2=serv.accept();
			st2=new ServerThread(s2);
			e2=new serverexe(st2,s2);
			e2.run();
		}
		catch(Exception r)
		{
			count--;
		}
		
	}
}
