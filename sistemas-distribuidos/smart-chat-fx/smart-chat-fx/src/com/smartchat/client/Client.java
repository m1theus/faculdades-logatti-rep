package com.smartchat.client;

import com.smartchat.server.IChat;
import com.smartchat.server.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.stream.Collectors;

import static com.smartchat.server.ServerApplication.SERVER_URI;

public class Client implements Runnable {

    private IChat chat;
    public ObservableList<String> chatLog;

    public Client() {
        chatLog = FXCollections.observableArrayList();
        try {
            chat = (IChat) Naming.lookup(SERVER_URI);
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
    }

    public void writeToServer(String userName, String text) {
        try {
            chat.sendMessage(new Message(userName, text));
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    public ObservableList<String> retrieveMessage(String userName) throws RemoteException {
        return FXCollections.observableList(chat.retrieveMessage(userName)
                .stream()
                .map(message -> String.format("[%s] - %s", message.getAuthor(), message.getMessage()))
                .collect(Collectors.toList()));
    }
}