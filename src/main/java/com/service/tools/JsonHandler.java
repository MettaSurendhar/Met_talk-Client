package com.service.tools;

import java.util.List;
import java.util.Map;

public class JsonHandler {

	private static JsonHandler instance;
	
	public static JsonHandler getInstance() {
		if (instance == null) {
			instance = new JsonHandler();
		}
		return instance;
	}
	
	public String extractMessageContent(String json) {
	    String value = null;
	    int startIndex = json.indexOf(":") + 2;
	    int endIndex = json.lastIndexOf("\"");
	    if (startIndex > 1 && endIndex > startIndex) {
	        value = json.substring(startIndex, endIndex);
	    }
	    return value;
	}
	
	public String createJSONMessages(List<String> messages) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (String message : messages) {
            jsonBuilder.append("{\"content\": \"").append(message).append("\"},");
        }
        if (!messages.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
	
	public String createJSONUsers(List<Map<String,String>> users) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (Map<String, String> message : users) {
            jsonBuilder.append("{\"content\": \"").append(message).append("\"},");
        }
        if (!users.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
