package com.reachInbox.model;

import org.springframework.stereotype.Component;

@Component
public class AIResponseGenerator {

    public String generateResponse(String emailContent) {
        // Placeholder logic to generate AI-based response
        if (emailContent.contains("update")) {
            return "Sure, here's the latest update on the project...";
        } else {
            return "Thank you for your message. I'll get back to you shortly.";
        }
    }
}