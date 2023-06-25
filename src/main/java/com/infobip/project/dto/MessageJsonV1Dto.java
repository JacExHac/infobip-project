package com.infobip.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class MessageJsonV1Dto {

    @Getter
    @Setter
    private String from;

    @Getter
    @Setter
    private String to;

    @Getter
    @Setter
    private String text;

    public MessageJsonV1Dto(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public MessageJsonV1Dto() {
    }

    @Override
    public String toString() {
        return "MessageJsonV1Dto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
