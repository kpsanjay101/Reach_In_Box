package com.reachInbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reachInbox.service.EmailService;
import com.theokanning.openai.OpenAiHttpException;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

@RestController

public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @GetMapping("/getResponse/{prompt}")
    public ResponseEntity<?> getMessage(@PathVariable String prompt){
        try {
            OpenAiService serv = new OpenAiService("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");
            CompletionRequest comReq = CompletionRequest.builder().prompt(prompt).model("davinci-003").echo(true).build();
            CompletionResult completionResult = serv.createCompletion(comReq);
            return ResponseEntity.ok(completionResult);
        } catch (OpenAiHttpException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
    
    @PostMapping("/parseEmail")
    public ResponseEntity<String> parseEmails() {
        emailService.parseAndRespondToEmails();
        return ResponseEntity.ok("Email parsing and response generation initiated.");
    }
}
