package com.infobip.project.dto;

import com.infobip.project.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


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


    @Getter
    @Setter
    private List<MessageDto> messages;

    public ConversationDto(String senderPhoneNumber, String receiverPhoneNumber, LocalDateTime startTime, LocalDateTime endTime) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
