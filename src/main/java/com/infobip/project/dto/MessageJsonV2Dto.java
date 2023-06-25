package com.infobip.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

public class MessageJsonV2Dto {
    private String from;
    private String to;
    private Content content;
    private String displayName;

    public MessageJsonV2Dto() {

    }

    public MessageJsonV2Dto(String from, String to, String text, String displayName) {
        this.from = from;
        this.to = to;
        this.content = new Content(text);
        this.displayName = displayName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        if (content != null) {
            return content.getText();
        }
        return null;
    }

    public void setText(String text) {
        if (content == null) {
            content = new Content();
        }
        content.setText(text);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static class Content {
        private String text;

        public Content() {
            // Default constructor
        }

        public Content(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

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


