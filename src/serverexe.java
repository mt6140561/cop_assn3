
import java.net.*;
public class serverexe {
	ServerThread st=null;
	Socket s=null;
	public serverexe(ServerThread a, Socket c){
		st=a;
		s=c;
	}
	public void run(){
		//st.f=false;
		////st.start();
		//while(!st.completed){}
		//String message=st.messagein;
		System.out.println("222");
		st.f=true;
		st.messageout="hey bitches";
		st.start();
		
		
	}
			
}
