import java.io.*;
import java.net.*;

public class GameServer {
	public int portNo;
	public GameServer(int portNo){
		this.portNo = portNo;
		try {
			ServerSocket server = new ServerSocket(portNo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
