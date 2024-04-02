package com.reachInbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reachInbox.model.AIResponseGenerator;
import com.reachInbox.model.Email;
import com.reachInbox.model.EmailParser;
import com.reachInbox.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
    private EmailParser emailParser;

    @Autowired
    private AIResponseGenerator aiResponseGenerator;
	
    @Override
	public void parseAndRespondToEmails() {
    	List<Email> emails = emailParser.parseEmails(); // Implement email parsing logic
        for (Email email : emails) {
            String response = aiResponseGenerator.generateResponse(email.getContent()); // AI-based response generation
            sendResponse(email.getSender(), response); // Method to send response
        }
	}

	@Override
	public void sendResponse(String recipient, String response) {
		// TODO Auto-generated method stub
		System.out.println("Sending response to " + recipient + ": " + response);
	}

}
