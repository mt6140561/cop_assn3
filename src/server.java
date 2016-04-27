import java.io.IOException;
import java.net.*;
public class Server {
	public static void main(String [] args) throws IOException{
		ServerSocket serv=new ServerSocket(1000);
		serv.setSoTimeout(5000);
		Socket s=serv.accept();
		ServerThread st=new ServerThread(s);
		Socket s1=serv.accept();
		ServerThread st1=new ServerThread(s1);
		Socket s2=serv.accept();
		ServerThread st2=new ServerThread(s2);
		st.start();
		while(st.messagein==null){String message=st.messagein;}
		String message=st.messagein;
		st1.start();
		String messa=st1.messagein;
		st2.start();
		String messag=st1.messagein;
		System.out.println(message+" "+messa+" "+messag);
		st.f=true;
		st1.f=true;
		st2.f=true;
		st.messageout="hey bitches";
		st2.messageout="hey bitches";
		st1.messageout="hey bitches";
		st.start();
		st1.start();
		st2.start();
	}
}