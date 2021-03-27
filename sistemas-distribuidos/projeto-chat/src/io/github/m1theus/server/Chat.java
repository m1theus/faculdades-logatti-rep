package io.github.m1theus.server;

import io.github.m1theus.database.ChatRepository;
import io.github.m1theus.entity.ChatEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Chat extends UnicastRemoteObject implements IChat {

    private ChatRepository chatRepository;

    public Chat() throws RemoteException {
        super();
        this.chatRepository = new ChatRepository();
    }


    @Override
    public void sendMessage(Message message) throws RemoteException {
        Message.setMessage(message);
        try {
            this.chatRepository.insert(ChatEntity.from(message));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Message> retrieveMessage() throws RemoteException {
        return Message.retrieveMessages();
    }

    public List<Message> retrieveMessageFromDb() throws RemoteException {
        try {
            return Message.from(this.chatRepository.findAll());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return Collections.emptyList();
    }
}
