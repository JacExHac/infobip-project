package com.infobip.project.repository;

import com.infobip.project.model.Conversation;
import com.infobip.project.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
     List<Message> findByConversation(Conversation conversation);
}
