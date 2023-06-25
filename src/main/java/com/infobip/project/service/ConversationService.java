package com.infobip.project.service;

import com.infobip.project.billing.BillingProcedure;
import com.infobip.project.billing.ChargedUserStatus;
import com.infobip.project.dto.MessageJsonV1Dto;
import com.infobip.project.model.Conversation;
import com.infobip.project.model.Message;
import com.infobip.project.model.Person;
import com.infobip.project.repository.ConversationRepository;
import com.infobip.project.repository.MessageRepository;
import com.infobip.project.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ConversationService {

    private Map<String, Conversation> activeConversations;
    private final BillingProcedure billingProcedure;
    private final ConversationRepository conversationRepository;
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    public ConversationService(BillingProcedure billingProcedure, ConversationRepository conversationRepository, PersonRepository personRepository, MessageRepository messageRepository) {
        this.activeConversations = new HashMap<>();
        this.billingProcedure = billingProcedure;
        this.conversationRepository = conversationRepository;
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public String processMessage(MessageJsonV1Dto messageReceived) {
        Optional<Person> sender = personRepository.findByPhoneNumber(messageReceived.getFrom());
        Conversation conversation = activeConversations.get(messageReceived.getFrom());


        if (conversation == null && sender.isPresent()) {

            if(billingProcedure.userHasFunds(sender.get())) {

                conversation = buildConversationEntity(messageReceived, sender.get());

                activeConversations.put(messageReceived.getFrom(), conversation);

                conversationRepository.save(conversation);

                ChargedUserStatus status = billingProcedure.chargeUser(sender.get());
                //TODO use the status to handle errors
            } else {
                return "No funds";
            }
        }

        if(sender.isPresent()) {
            Message message = buildMessageEntity(messageReceived.getText(), conversation);

            // Add the message to the conversation
            messageRepository.save(message);
        }

        return messageReceived.getText();

    }

    private Message buildMessageEntity(String content, Conversation conversation) {
        Message message = new Message();

        message.setConversation(conversation);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        return message;
    }

    private Conversation buildConversationEntity(MessageJsonV1Dto messageReceived, Person sender) {
        Conversation conversation = new Conversation();
        conversation.setPerson(sender);
        conversation.setReceiverId(messageReceived.getTo());
        conversation.setStartTime(LocalDateTime.now());
        conversation.setMessages(new ArrayList<>());


        return conversation;
    }


}
