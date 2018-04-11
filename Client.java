
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
  
 
    	String word;
    	Scanner inFromUser= new Scanner(System.in);
    	
    	try (Socket clientSocket = new Socket("localhost",6786)) {
    	    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    	    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
    	    
    	    word = inFromUser.next();

    	    outToServer.writeObject(word);
    	    
    	    String arrFromServer = (String)inFromServer.readObject();
    	    
    	        System.out.print(""+arrFromServer);
    	    
    		}
   
   
    	}
    
}