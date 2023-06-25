package com.infobip.project.controller;

import com.infobip.project.dto.ConversationDto;
import com.infobip.project.model.Conversation;
import com.infobip.project.service.ConversationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/conversations")
public class ConversationController {

    ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/{id}")
    public ConversationDto getConversationById(@PathVariable Long id) {
        ConversationDto conversationDto = conversationService.getConversationById(id);

        return conversationDto;

    }
}
