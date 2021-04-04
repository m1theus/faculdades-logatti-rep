package com.smartchat.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerApplication {
    private static final int SERVER_PORT = 1337;
    public static final String SERVER_URI = String.format("rmi://localhost:%s/chat", SERVER_PORT);

    protected ServerApplication() {
    }

    protected void start() {
        try {
            LocateRegistry.createRegistry(SERVER_PORT);
            Naming.rebind(SERVER_URI, new Chat());
            System.out.println("started the server at port: " + SERVER_PORT);
        } catch (final Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        final var chatServer = new ServerApplication();
        chatServer.start();
    }
}
