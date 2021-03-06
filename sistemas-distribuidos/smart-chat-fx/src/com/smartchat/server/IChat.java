package com.smartchat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {
    void sendMessage(Message message) throws RemoteException;

    List<Message> retrieveMessage(String userName) throws RemoteException;
}
