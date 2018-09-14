=============================================================================================================
==== Messaging ====

Contributers: Austin Dvorak

=== Description ===

Simple terminal based chat application that can be run
in an IDE or via command line with few changes

=== Running in Eclipse ===

	to run in eclipse, unpack the directory and then open eclipse in any workspace

	go to file > import > general > Projects from Folder or Archive >

	click on directory and navigate to the unpacked folder and click on the Homework_1 folder

	click finish and the project should show up in the package explorer

	=== to run the file ===
		1. right click on Server.java and select run as > java application
		2. right click on Client.java and select run as > java application
		3. enter name as prompted
		4. repeat steps 3 and 4 to start as much clients on the same server as you want
		5. navigate between the terminals to see the server side or the clients you started
		   to send messages
		   (note: the server merely displays messages, in order to communicate between 2
			terminals sending and receiving at least 2 clients have to be open)

=== Running via Terminal ==

 	1. unpack the directory and then in a text editor comment out the lines
		package client; in Client.java and Server_thread.java
		package server; in Server.java and Client_thread.java
	2. open up a terminal and navigate to the server package
		input the command javac Server.java	 //this will generate the class file
		input the command java Server 		 //this will start the server
	3. open another terminal instance and navigate to the client package
		input the command javac Client.java	 //this will generate the class file
		input the command java Client		 //this will start the server
		input name
	4. repeat step 3 to start multiple clients
		(note: in order to actually chat between 2 people you must open at least 2 clients
 		as the server merely displays the messages and doesn't actually send messages that weren't
		given by the client)

=== Requires java jdk 1.5 and above and either a Java IDE or a Java compliant command line ===
=============================================================================================================
