import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ChatServerThread implements ActionListener
{  private ChatServer       server    = null;
   private Socket           socket    = null;
   private int              ID        = -1;
   private DataInputStream  streamIn  =  null;
   private DataOutputStream streamOut = null;
  
   int t=0;
   Timer tm;
   String s="4 0 0 0 40 60";
   public ChatServerThread(ChatServer _server, Socket _socket) throws IOException
  
   {  super();
      server = _server;
      socket = _socket;
      streamIn = new DataInputStream(new 
              BufferedInputStream(socket.getInputStream()));
streamOut = new DataOutputStream(new
              BufferedOutputStream(socket.getOutputStream()));
      ID     = socket.getPort();
     
      tm =new Timer(5,this);
      tm.start();
 
   }
   public void send(String msg)
   {  s=server.s4;
	   try
       {if(t%2==0){  
    	   System.out.println("adasd");
	   streamOut.writeUTF(s);
	   t=t+1;}
       else{
    	   streamOut.writeUTF(msg);
    	System.out.println(s);  
       
    	System.out.println(server.s4);  
        
       }
       
          streamOut.flush();
       }
       catch(IOException ioe)
       {  System.out.println(ID + " ERROR sending: " + ioe.getMessage());
          server.remove(ID);
          
//          stop();
       }
   }
   public int getID()
   {  return ID;
   }
//   public void run()
//   {  System.out.println("Server Thread " + ID + " running.");
//      while (true)
//      {  try
//         {  server.handle(streamIn.readUTF());
//         }
//         catch(IOException ioe)
//         {  System.out.println(ID + " ERROR reading: " + ioe.getMessage());
//            server.remove(ID);
////            stop();
//         }
//      }
//   }
   public void open() throws IOException
   {  streamIn = new DataInputStream(new 
                        BufferedInputStream(socket.getInputStream()));
      streamOut = new DataOutputStream(new
                        BufferedOutputStream(socket.getOutputStream()));
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
      if (streamOut != null) streamOut.close();
   }
   
   
   
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	{
	try
    { 
		server.handle(streamIn.readUTF());
    
    }
    catch(IOException ioe)
    {  System.out.println(ID + " ERROR reading: " + ioe.getMessage());
       server.remove(ID);
//       stop();
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
}
