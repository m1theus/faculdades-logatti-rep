package io.github.m1theus.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ChatServer {
    public static final int SERVER_PORT = 1337;
    public static final String SERVER_URL = "rmi://localhost:" + SERVER_PORT + "/chat";

    public ChatServer() throws RemoteException {
        try {
            LocateRegistry.createRegistry(SERVER_PORT);
            Naming.rebind(SERVER_URL, new Chat());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new ChatServer();
    }

}
