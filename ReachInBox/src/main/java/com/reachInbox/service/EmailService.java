package com.reachInbox.service;

public interface EmailService {
	
	public void parseAndRespondToEmails();
	public void sendResponse(String recipient, String response);
}
