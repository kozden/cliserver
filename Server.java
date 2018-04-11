
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server {

    private static ServerSocket ss;
    
	public static void main(String[] args) throws IOException, ClassNotFoundException {
      
		ServerSocket welcomeSocket = new ServerSocket(6786);
		while(true){
		    Socket connectionSocket = welcomeSocket.accept();
		    ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
		    ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
		    
		    String arrFromClient = (String) inFromClient.readObject();
			char[] sezararr = arrFromClient.toCharArray();
		    	
			for(int i=0; i<sezararr.length; i++) {          

				int asciiSirasi = (int)sezararr[i];                          
				
				if(asciiSirasi == 32)                 
					
					sezararr[i] = ' ';              

				else {                 
				
					if(asciiSirasi >=65 && asciiSirasi <=90) {                     

						if((asciiSirasi+4) >90)

									sezararr[i] = (char) (((asciiSirasi+4)%90) + 64);
			                    	
						else
			                        
							sezararr[i] = (char) (asciiSirasi+3);
			                
					}
			                
			        if(asciiSirasi >=97 && asciiSirasi <=122) {                     

						if((asciiSirasi+4) >122)
			                        
							sezararr[i] = (char) (((asciiSirasi+4)%122) + 96 );
			                    	
						else
			                        
							sezararr[i] = (char) (asciiSirasi+3);
			                
						}
			            
					}
			            
			            
			   	}
			       
			String newword = String.valueOf(sezararr);
		    
		    outToClient.writeObject(newword);
		}
        
	}
	
    
}



