package com.service.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class ChatHandler {

	
    private static List<String> incomingMessages = new ArrayList<>();

    public static void handleIncomingMessage(String message) {
        incomingMessages.add(message);
        System.out.println("lists of msg:" + incomingMessages);
    }

    
    public static List<String> getIncomingMessages() {
        return incomingMessages;
    }
    
    public static void clearIncomingMessages() {
        incomingMessages.clear();
    }

	
}
