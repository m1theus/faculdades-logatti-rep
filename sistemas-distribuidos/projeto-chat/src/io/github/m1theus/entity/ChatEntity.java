package io.github.m1theus.entity;

import io.github.m1theus.server.Message;

public class ChatEntity {
    private Long id;
    private String author;
    private String message;

    public ChatEntity(Long id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public static ChatEntity from(Message message) {
        return new ChatEntity(null, message.getAuthor(), message.getMessage());
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
