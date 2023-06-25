package com.infobip.project.repository;

import com.infobip.project.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
