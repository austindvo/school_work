package client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 
 * @author austindv
 * 
 * Creates a chat client that prompts a username for that instance, 
 * connects on localhost port 5000
 * prints that it connects to the server to the terminal, 
 * and starts a new thread for that chat client, relaying the socket information
 * and name of the user
 *
 */
public class Client{
	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws UnknownHostException, InterruptedException{
		
		//creates a new socket and initializes to null
		Socket socket = null;
		
		//prompts user to enter their name in the terminal
		System.out.print("> Enter your Name: (type in your name, then press Enter) ");
		
		//creates a new scanner that scans the terminal
		Scanner scanner = new Scanner(System.in);
		
		//sets String name to the resulting String from the terminal
		String name = scanner.nextLine();
		
		//try catch block to catch if the client cannot connect
		try {

		    //connect to locahost on port 5000
			socket = new Socket("127.0.0.1", 5000);
			
			//Print that the Client has connected to the server successfully
			System.out.println("Connected to server");
			
			//sleep thread to make sure it is ready to make a new one
			Thread.sleep(1000);
			
			//make a new thread for the client that includes the socket information and the name of the client
			Thread server = new Thread(new Server_thread(socket, name));
			
			//start the thread 
			server.start();


		} catch(IOException u) {
					//print the exception found
            		System.out.println(u);
        }

	}

}



