 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServerExample {
     
    //static ServerSocket variable
    static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    public SocketServerExample()throws Exception{
    	server = new ServerSocket(port);
    	socket=server.accept();
    }
    
     Socket socket;
     Socket socket2;
    public static void main(String args[]) throws Exception{
        //create the socket server object
        
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
        	SocketServerExample abc = new SocketServerExample();
        	//   System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
        //    Socket socket = server.accept();
            //read from socket to ObjectInputStream object
          ObjectInputStream ois = new ObjectInputStream(abc.socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(abc.socket.getOutputStream());
            //write object to Socket
            oos.writeObject("Hi Client ");
            //close resources
           ois.close();
            oos.close();
            abc.socket.close();
            server.close();
            //terminate the server if client sends exit request
        //    if(message.equalsIgnoreCase("exit")) break;
        }
   //     System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
     //   server.close();
    }
     
}