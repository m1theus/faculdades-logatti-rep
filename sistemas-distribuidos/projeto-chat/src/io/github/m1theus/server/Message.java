package io.github.m1theus.server;

import io.github.m1theus.entity.ChatEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    private String author;
    private String message;

    private static List<Message> messages = new ArrayList<>();

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
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
        return this.getAuthor();
    }

    public static List<Message> from(List<ChatEntity> entities) {
        List<Message> newMessages = new ArrayList<>();

        for (ChatEntity entity : entities) {
            newMessages.add(new Message(entity.getAuthor(), entity.getMessage()));
        }

        return newMessages;
    }
}
