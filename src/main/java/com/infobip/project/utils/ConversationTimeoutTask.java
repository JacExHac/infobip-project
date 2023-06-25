package com.infobip.project.utils;

import com.infobip.project.model.Conversation;
import com.infobip.project.service.ConversationService;

import java.util.Timer;
import java.util.TimerTask;

public class ConversationTimeoutTask extends TimerTask {
    private final ConversationService conversationService;
    private final Conversation conversation;
    private final long CONVERSATION_TIMEOUT = 20000;

    Timer timer;


    public ConversationTimeoutTask(ConversationService conversationService, Conversation conversation) {
        this.timer = new Timer();


        this.conversationService = conversationService;
        this.conversation = conversation;

    }

    @Override
    public void run() {
        conversationService.closeConversation(conversation);
    }

    public void startTimeout() {
        timer.schedule(this, CONVERSATION_TIMEOUT);
    }

    public void resetTimeout() {
        timer.cancel();
        timer = new Timer();
        timer.schedule(new ConversationTimeoutTask(conversationService, conversation), CONVERSATION_TIMEOUT);
    }
}