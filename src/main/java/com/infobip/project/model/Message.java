package com.infobip.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @Getter
    @Setter
    private Long messageId;

    @Getter
    @Setter
    private Long timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conversation conversation;
}
