<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======

>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	 protected Socket socket;
	 public String messagein;
	 public String messageout;
<<<<<<< HEAD
<<<<<<< HEAD
	 public boolean f=false,completed=false;
	 
=======
	 public boolean f=false;
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======
	 public boolean f=false,completed=false;
	 
>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
	    public ServerThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    
	    public void run() {
<<<<<<< HEAD
<<<<<<< HEAD
	    	completed=false;
=======
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======
	    	completed=false;
>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
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
<<<<<<< HEAD
	        
=======
	        String line;
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
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
<<<<<<< HEAD
<<<<<<< HEAD
		        	System.out.print(messageout);
					out.writeUTF(messageout);
				
		        } 
=======
					out.writeUTF(messageout);
				} 
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======
		        	System.out.print(messageout);
					out.writeUTF(messageout);
				
		        } 
>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
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
<<<<<<< HEAD
<<<<<<< HEAD
	            completed=true;
=======
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======
	            completed=true;
>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
	            }
	        
	        
	    }
<<<<<<< HEAD
<<<<<<< HEAD
	    


=======
>>>>>>> 2669a0ae072a3e358a9060359cfde8afaec6c4e6
=======
	    


>>>>>>> e846ea06dd297c0a24027b96d966eb095591c475
