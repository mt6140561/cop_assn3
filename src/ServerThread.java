
import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	 protected Socket socket;
	 public String messagein;
	 public String messageout;
	 public boolean f=false,completed=false;
	 
	    public ServerThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    
	    public void run() {
	    	completed=false;
	        InputStream inp = null;
	        DataInputStream brinp = null;
	        DataOutputStream out = null;
	        try {
	            inp = socket.getInputStream();
	            brinp = new DataInputStream(inp);
	            out = new DataOutputStream(socket.getOutputStream());
	        } catch (IOException e) {
	            return;
	        }
	        String line;
	        if(f==false){
	        try {
				messagein=brinp.readUTF();
				System.out.print(messagein);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        }
	        if(f==true){
	        	//try {
				//	messagein=brinp.readUTF();
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
		        try {
		        	System.out.print(messageout);
					out.writeUTF(messageout);
				
		        } 
		        catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
					}
		        
	        }
	            
	            try{
	               // System.out.println("Connection Closing..");
	                if (inp!=null){
	                    inp.close(); 
	                    System.out.println(" Socket Input Stream Closed");
	                }

	                if(brinp!=null){
	                    brinp.close();
	               //     System.out.println("Socket Out Closed");
	                }
	                if (out!=null){
	                out.close();
	             //   System.out.println("Socket Closed");
	                }

	                }
	            catch(IOException ie){
	                System.out.println("Socket Close Error");
	            }
	            completed=true;
	            }
	        
	        
	    }
	    


