package io.github.m1theus;

import io.github.m1theus.server.ChatServer;
import io.github.m1theus.server.IChat;
import io.github.m1theus.server.Message;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String name = JOptionPane.showInputDialog("[CHAT] Informe seu nome: ");

        try {
            String message = "";
            while (!"0".equals(message)) {
                message = JOptionPane
                        .showInputDialog(String.format("[CHAT] %s entre com a mensagem. (Informe 0 para sair)", name));

                sendMessage(name, message);
            }

        } catch (final Exception exception) {
            exception.printStackTrace();
        }

    }

    private static void sendMessage(String name, String message) throws RemoteException, NotBoundException, MalformedURLException {
        IChat chat = (IChat) Naming.lookup(ChatServer.SERVER_URL);
        chat.sendMessage(new Message(name, message));

        System.out.println(formatMessages(chat.retrieveMessage()));
    }

    private static String formatMessages(List<Message> messages) {
        StringBuilder formattedMessage = new StringBuilder();

        for (Message msg : messages) {
            formattedMessage.append(String.format("[Author] %s: %s \n", msg.getAuthor(), msg.getMessage()));
        }

        return formattedMessage.toString();
    }

}
