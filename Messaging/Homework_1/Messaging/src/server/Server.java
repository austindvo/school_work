package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * 
 * @author austindv
 * 
 * class that starts the server for the chat program that 
 * automatically takes in clients as they connect to the server,
 * prints out what each person says, and relays that information
 * to every other user on the server except the person that sends 
 * the message/name
 *
 */
public class Server {

	//creates a new server socket and initializes it to null
	private static ServerSocket server 			= null;
	
	//creates a new ArrayList that adds a new user when they connect
	//so the server can send messages to everyone
	protected static ArrayList<Client_thread> 	clients;

	public static void main(String args[]) {
		
		//surround methods in a try catch block to make sure the server cannot
		// connect to clients or throw an IOException when it fails
		try {
			//set the server socket to a new ServerSocket at port 5000
			server = new ServerSocket(5000);
			
			//Print to terminal that the server was started
			System.out.println("Server Started");
			
			//run the accept_clients() method that automatically adds unlimited
			//clients as they try to connect
			accept_clients();
			
		} catch (IOException x) {
			//print that the server could not connect on port 5000
			System.err.println("Could not listen on port 5000" + x);
			System.exit(1);
		}

	}
	
	/**
	 * accepts any new clients and adds them to the arraylist clients
	 */
	public static void accept_clients(){
		
		//set the clients ArrayList to a new list of Client_threads
		clients = new ArrayList<Client_thread>();
		
		//run forever to accept any clients that want to connect and add them to the ArrayList clients
		while(true){
			
			//surround in a try catch block to catch an exception if the server fails to accept the client
			try{
				
				//print that the server is waiting for clients to connect
				System.out.println("Waiting For Client");
				
				//accept the client that wants to connect
				Socket socket = server.accept();
				
				//print that the server successfully connected to the client
				System.out.println("Client connected");
				
				//create a new client object Client_thread to handle the client and send the socket info to it
				Client_thread client = new Client_thread(socket);
				
				//create a new thread Client_thread with the object client
				Thread thread = new Thread(client);
				
				//start the thread
				thread.start();
				
				//add the client object to the ArrayList clients
				clients.add(client);
				
			} catch (IOException e){
				//catch that the server could not connect to the client thread
				System.out.println("Accept Failed");
			}
		}
	}
}

