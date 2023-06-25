package com.infobip.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    @Getter
    @Setter
    private String content;


    @Getter
    @Setter
    private LocalDateTime timestamp;
}
