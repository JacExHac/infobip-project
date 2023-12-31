package com.infobip.project.controller;

import com.infobip.project.dto.MessageJsonV1Dto;
import com.infobip.project.dto.MessageJsonV2Dto;
import com.infobip.project.model.Conversation;
import com.infobip.project.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
@RequestMapping("/api")
public class ApiController {


    private final ConversationService conversationService;

    @Autowired
    public ApiController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/v1")
    public ResponseEntity<String> postRequestv1(@RequestBody MessageJsonV1Dto messageReceived) {

        String responseMessage = conversationService.processMessage(messageReceived);


        return ResponseEntity.ok(responseMessage);
    }


    @PostMapping("/v2")
    public ResponseEntity<String> postRequestv2(@RequestBody MessageJsonV2Dto messageReceived) {

        MessageJsonV1Dto messageJsonV1Dto = new MessageJsonV1Dto(messageReceived.getFrom(),messageReceived.getTo(),messageReceived.getContent().getText());

        String responseMessage = conversationService.processMessage(messageJsonV1Dto);


        return ResponseEntity.ok(responseMessage);
    }
}
