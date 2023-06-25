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
import com.infobip.project.utils.ConversationTimeoutTask;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ConversationService {

    private Map<String, Conversation> activeConversations;
    private Map<Conversation, ConversationTimeoutTask> activeTimeoutTasks;
    private final BillingProcedure billingProcedure;
    private final ConversationRepository conversationRepository;
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    public ConversationService(BillingProcedure billingProcedure, ConversationRepository conversationRepository, PersonRepository personRepository, MessageRepository messageRepository) {
        this.activeConversations = new HashMap<>();
        this.activeTimeoutTasks = new HashMap<>();

        this.billingProcedure = billingProcedure;
        this.conversationRepository = conversationRepository;
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public String processMessage(MessageJsonV1Dto messageReceived) {
        Optional<Person> sender = personRepository.findByPhoneNumber(messageReceived.getFrom());
        Conversation conversation = activeConversations.get(messageReceived.getFrom());

        if(sender.isPresent()) {
            if(conversation == null) {
                if (billingProcedure.userHasFunds(sender.get())) {
                    conversation = buildConversationEntity(messageReceived, sender.get());


                    conversationRepository.save(conversation);

                    activeConversations.put(messageReceived.getFrom(), conversation);

                    //maps the conversation and its reset value in memory
                    ConversationTimeoutTask conversationTask = new ConversationTimeoutTask(this, conversation);
                    conversationTask.startTimeout();
                    activeTimeoutTasks.put(conversation, conversationTask);


                    ChargedUserStatus status = billingProcedure.chargeUser(sender.get());
                    // TODO: Use the status to handle errors
                } else {
                    return "No funds...";
                }
            }
        } else {
            return "Your phone number isn't registered...";
        }


        if (sender.isPresent()) {
            Message message = buildMessageEntity(messageReceived.getText(), conversation);
            messageRepository.save(message);
            activeTimeoutTasks.get(conversation).resetTimeout();
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

    public void closeConversation(Conversation conversation) {

        // Update the end time of a conversation and update the database
        conversation.setEndTime(LocalDateTime.now());
        conversationRepository.save(conversation);

        // Remove the conversation from the active conversations map and the task map
        activeConversations.remove(conversation.getPerson().getPhoneNumber());

        activeTimeoutTasks.remove(conversation);
    }
}


