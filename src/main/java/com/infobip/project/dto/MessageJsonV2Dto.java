package com.infobip.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class MessageJsonV2Dto {
    @Getter
    @Setter
    private String from;

    @Getter
    @Setter
    private String to;

    @Getter
    @Setter
    private ContentV2 content;

    @Getter
    @Setter
    private String displayName;


    @Override
    public String toString() {
        return "MessageJsonV2Dto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content=" + content +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}

