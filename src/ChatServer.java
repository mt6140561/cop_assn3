import java.net.*;
import java.io.*;

public class ChatServer implements Runnable
{  ChatServerThread clients[] = new ChatServerThread[50];
    ServerSocket server = null;
    Thread       thread = null;
   private int clientCount = 0;
   String s1="";
   String s2="";
   String s3="";
   String s4="";
   private DataOutputStream streamOut = null;
   ChatClient client = null;

   public ChatServer(int port)
   {  
	   try
      {
		   
		 System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);  
           //System.out.println("Server started: " + server);

          start();

     //   client = new ChatClient("localhost", port);   
        
      }
      catch(IOException ioe)
      {  System.out.println("Can not bind to port " + port + ": " + ioe.getMessage()); }
   }
   
   
   public void run()
   {  while (thread != null)
      {  try
         {  System.out.println("Waiting for a client ..."); 
            addThread(server.accept()); }
         catch(IOException ioe)
         {  System.out.println("Server accept error: " + ioe); stop(); }
      }
   }
   
   public void start()  { 
	
	   if (thread == null)
	      {  thread = new Thread(this); 
	         thread.start();
	      }
   
   /* as before */ }
   public void stop(){
	   if (thread != null)
	      {  thread.stop(); 
	         thread = null;
	      }
	   
   
   /* as before */ }
   
   
   private int findClient(int ID)
   {  for (int i = 0; i < clientCount; i++)
         if (clients[i].getID() == ID)
            return i;
      return -1;
   }
   public void abc(){
	   
   }
   
   public synchronized void handle( String input)
   {
	   if (input.equals(".bye"))
      {}
      else{
    	  {  for (int i = 0; i < clientCount; i++)
         {
        	 
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
        
   System.out.println("yahan b phuncha");
        clients[i].send( input);}  
      }
   }}
   public synchronized void remove(int ID)
   {  int pos = findClient(ID);
      if (pos >= 0)
      {  ChatServerThread toTerminate = clients[pos];
         System.out.println("Removing client thread " + ID + " at " + pos);
         if (pos < clientCount-1)
            for (int i = pos+1; i < clientCount; i++)
               clients[i-1] = clients[i];
         clientCount--;
         try
         {
        	 toTerminate.close();
         }
         catch(IOException ioe)
         {  System.out.println("Error closing thread: " + ioe); }
//         toTerminate.stop(); 
         }
   }
   private void addThread(Socket socket) throws IOException
   {  if (clientCount < clients.length)
      {  System.out.println("Client accepted: " + socket);
         clients[clientCount] = new ChatServerThread(this, socket);
         System.out.println("charserverthread stared");
         try
         {
         clients[clientCount].open(); 
         System.out.print("client opened");
//            clients[clientCount].start();  
            clientCount++; }
         catch(Exception ioe)
         {  System.
        	 out.println("Error opening thread: " + ioe); } }
      else
         System.out.println("Client refused: maximum " + clients.length + " reached.");
   }
   public static void main(String args[]) { 
	   
	   
	   ChatServer server = null;
	      
	         server = new ChatServer(22);
	         
	   /* as before */ }
}