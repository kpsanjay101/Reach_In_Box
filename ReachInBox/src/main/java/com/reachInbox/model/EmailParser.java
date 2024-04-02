package com.reachInbox.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmailParser {

    public List<Email> parseEmails() {
        // Placeholder logic to simulate parsing emails
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("sender1@example.com", "Hello, how are you?"));
        emails.add(new Email("sender2@example.com", "Can you provide an update on the project?"));
        return emails;
    }
}
