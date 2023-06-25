package com.infobip.project.controller;

import com.infobip.project.dto.MessageJsonV1Dto;
import com.infobip.project.model.Conversation;
import com.infobip.project.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ApiController {


    private final ConversationService conversationService;

    @Autowired
    public ApiController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/v1")
    public ResponseEntity<String> postRequest(@RequestBody MessageJsonV1Dto messageReceived) {

        String responseMessage = conversationService.processMessage(messageReceived);


        return ResponseEntity.ok(responseMessage);
    }


    //@PostMapping("/v2")
}
