package com.infobip.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ConversationDto {
    @Getter
    @Setter
    private String senderPhoneNumber;

    @Getter
    @Setter
    private String receiverPhoneNumber;

    @Getter
    @Setter
    private LocalDateTime startTime;

    @Getter
    @Setter
    private LocalDateTime endTime;


}
