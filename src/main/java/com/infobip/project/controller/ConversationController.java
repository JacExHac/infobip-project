package com.infobip.project.controller;

import com.infobip.project.dto.ConversationDto;
import com.infobip.project.model.Conversation;
import com.infobip.project.service.ConversationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @GetMapping
    public List<ConversationDto> getConversationsByTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {

        // Call your service or repository to fetch conversations based on the time range
        List<ConversationDto> conversationDtos = conversationService.getConversationsByTimeRange(startTime, endTime);

        return conversationDtos;
    }


}
