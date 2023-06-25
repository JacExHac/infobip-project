package com.infobip.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Getter
    @Setter
    private LocalDateTime timestamp;

    @Getter
    @Setter
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Conversation conversation;
}
