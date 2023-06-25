package com.infobip.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long conversationId;

    @ManyToOne
    @JoinColumn(name = "person_phone_number", referencedColumnName = "phoneNumber")
    @Getter
    @Setter
    private Person person;

    @Getter
    @Setter
    private String receiverId;

    @Getter
    @Setter
    private LocalDateTime startTime;

    @Getter
    @Setter
    private LocalDateTime endTime;


    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private List<Message> messages = new ArrayList<>();

}
