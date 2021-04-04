package com.smartchat.server;

import com.smartchat.server.service.OrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import static com.smartchat.server.service.OrderService.CHAT_BOT;

public class Chat extends UnicastRemoteObject implements IChat {
    private static final long serialVersionUID = -5420577327564184837L;
    private final OrderService orderService;

    protected Chat() throws RemoteException {
        this.orderService = new OrderService();
        this.orderService.sendMessage(new Message(CHAT_BOT, "Olá, eu sou o Tob, em que posso ajuda-lo(a)?"));
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        orderService.sendMessage(message);
    }

    @Override
    public List<Message> retrieveMessage(String userName) throws RemoteException {
        return orderService.retrieveMessage();
    }
}
