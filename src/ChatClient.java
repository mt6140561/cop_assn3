import java.net.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.*;
public class ChatClient implements ActionListener
{ 
	public ArrayList<Ball> balls;
   Socket socket1              = null;
   Socket socket2=null;
   Socket socket3=null;
   Socket socket4=null;
   
   String s1="";
   String s2="";
   String s3="";
   String s4="";
String IP1;
int port1;
String IP2;
int port2;
String IP3;
int port3;
//    Thread thread              = null;
   private DataInputStream  console   = null;
   private DataOutputStream streamOut = null;
   private DataOutputStream streamOut2 = null;
   private DataOutputStream streamOut3 = null;
   private DataOutputStream streamOut4 = null;
//   private ChatClientThread client    = null;
   public Bat bat;
   Timer tim;
   int k;
   int t=0;
   public ChatClient(String serverName, int serverPort, Bat bat, int k,ArrayList<Ball> balls)
   {  System.out.println("Establishing connection. Please wait ...");
      try
      {  socket1 = new Socket(serverName, serverPort);
         System.out.println("Connected: " + socket1);
         console   = new DataInputStream(socket1.getInputStream());
         streamOut = new DataOutputStream(socket1.getOutputStream());
this.k=k;
        tim = new Timer(100, this);
        tim.start();
        this.balls=balls;
        
        this.bat = bat;
       
        
         
         
      }
      catch(UnknownHostException uhe)
      {  System.out.println("Host unknown: " + uhe.getMessage()); }
      catch(IOException ioe)
      {  System.out.println("Unexpected exception: " + ioe.getMessage()); }
     
   }
   public void abc(){
	   if(t%10==0){
		   actionPerformed(null);
	   }
	   else{
		   t=t+1;
		   abc();
	   }
   }
//   public void run()
//   {  while (thread != null)
//      {  try
//         {  streamOut.writeUTF(bat.x+" "+bat.y+" "+bat.velo+" "+balls.get(0).x+" "+balls.get(0).y);
//            streamOut.flush();
//         }
//         catch(IOException ioe)
//         {  System.out.println("Sending error: " + ioe.getMessage());
//            stop();
//         }
//      }
//   }
//   
//   
   
   
   public void handle(String msg)
   {  if (msg.equals(".bye"))
      {  System.out.println("Good bye. Press RETURN to exit ...");
         stop();
      }
      else{
       //  System.out.println(msg);
      }
   }
   public void start() throws IOException
   {  console   = new DataInputStream(socket1.getInputStream());
      streamOut = new DataOutputStream(socket1.getOutputStream());
    
//      if (thread == null)
//      {  client = new ChatClientThread(this, socket1);
//         thread = new Thread(this);                   
//         thread.start();
      }
   
   public void stop()
   {  
      try
      {  if (console   != null)  console.close();
         if (streamOut != null)  streamOut.close();
         if (socket1    != null)  socket1.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing ..."); }
//      client.close();  
//      client.stop();
   }
   public static void main(String args[])
   {  ChatClient client = null;
      
       //  client = new ChatClient("localhost", 22, new Bat(0 ,0,0,0,0));
   }
   public void io() throws IOException{
   String input =  console.readUTF();
   System.out.println(input);
   
   }
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	 System.out.println("qweq"); 
	try
   {  System.out.println("qweq");
		  
		  streamOut.writeUTF(""+k+" "+bat.x+" "+bat.y+" "+bat.velo+" "+balls.get(0).x+" "+balls.get(0).y);
	       streamOut.flush();
	    
	       System.out.print("gyi");
	     //  tim.stop();
	       
//		  String input ="nnnnn";
		String input =  console.readUTF();
		 System.out.println(input);
		if(input.substring(0,1).equals("1")){
			s1=input;   
		   }
			 
		   if(input.substring(0,1).equals("2")){
			   s2=input;   
		   }
		   if(input.substring(0,1).equals("3")){
			   s3=input;   
		   }
		   if(input.substring(0,1).equals("4")){
			   s4=input;   
		   }  
		  
	 
      
     }
   
   catch(IOException ioe)
   {  System.out.println("Sending error: " + ioe.getMessage());
//      stop();
   }
	
}

   
   

}