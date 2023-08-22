package com.service.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.service.main.ChatHandler;

public class Client {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String userDetails;
	
	
	public Client(Socket socket, String userDetails) {
		
		try {
			this.socket = socket;
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(),true);
			this.userDetails = userDetails;
		}catch(IOException e) {
			closeAll(socket,in,out);
		}
	}
	
	public void closeAll(Socket socket, BufferedReader input , PrintWriter output ) {
		
		try {
			if(input != null) input.close();
			if(output != null) output.close();
			if(socket != null) socket.close();
		}
		catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	public void sendMsg(String message) {
		
		try {
			if(!message.equals("null")) {
				out.println(message);
			}
		}
		catch(Exception e) {
			closeAll(socket,in,out);
		}		
		
	}
	
	public void listenMsg() {
		System.out.println("started receiving message");
		Thread thread = new Thread( new Runnable() {
			
			@Override
			public void run() {
				String msgFromGroup;
				while(socket.isConnected()) {
					try {
						msgFromGroup = in.readLine();
						if(!msgFromGroup.split(":")[3].equals("null")) ChatHandler.handleIncomingMessage(msgFromGroup);
					}
					catch(IOException e) {
						closeAll(socket,in,out);
						break;
					}
				}
			}
		});
		thread.start();
	}

}
