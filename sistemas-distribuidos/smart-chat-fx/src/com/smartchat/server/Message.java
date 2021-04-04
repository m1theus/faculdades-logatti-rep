package com.smartchat.server;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    private static final long serialVersionUID = 2180879229150919589L;
    private String author;
    private String message;
    private LocalDateTime dateAt;

    private static List<Message> messages = new ArrayList<>();

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
        this.dateAt = LocalDateTime.now();
    }

    public static List<Message> retrieveMessages() {
        return messages;
    }

    public static void setMessage(Message message) {
        messages.add(message);
    }

    public String getMessage() {
        return this.message;
    }

    public String getAuthor() {
        return this.author;
    }

    public LocalDateTime getDateAt() {
        return this.dateAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", dateAt=" + dateAt +
                '}';
    }
}

