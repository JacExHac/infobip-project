package com.infobip.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageJsonV2Dto {
    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("content")
    private Content content;

    @JsonProperty("displayName")
    private String displayName;

    public MessageJsonV2Dto() {
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static class Content {
        @JsonProperty("text")
        private String text;

        public Content() {
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
                ", content=" + content.getText() +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
