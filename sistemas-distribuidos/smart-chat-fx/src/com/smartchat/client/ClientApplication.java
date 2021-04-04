package com.smartchat.client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientApplication extends Application {
    public static final String NAME_NOT_BE_NULL = "Name not be null";
    private ArrayList<Thread> threads;
    private String userName;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        threads = new ArrayList<>();
        primaryStage.setTitle("Smart Chat");
        primaryStage.setScene(makeInitScene(primaryStage));
        primaryStage.show();
    }

    public Scene makeInitScene(Stage primaryStage) {
        /* Make the root pane and set properties */
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(20));
        rootPane.setVgap(10);
        rootPane.setHgap(10);
        rootPane.setAlignment(Pos.CENTER);

        /* Make the text fields and set properties */
        TextField nameField = new TextField();

        /* Make the labels and set properties */
        Label nameLabel = new Label("Name ");
        Label errorLabel = new Label();
        /* Make the button and its handler */
        Button submitClientInfoButton = new Button("Done");
        submitClientInfoButton.setOnAction(Event -> {
            /* Instantiate the client class and start it's thread */
            Client client;
            try {

                if ("".equals(nameField.getText()) || nameField.getText() == null) {
                    throw new IllegalArgumentException(NAME_NOT_BE_NULL);
                }

                client = new Client();
                Thread clientThread = new Thread(client);
                clientThread.setDaemon(true);
                clientThread.start();
                threads.add(clientThread);
                userName = nameField.getText();
                /* Change the scene of the primaryStage */
                primaryStage.close();
                primaryStage.setScene(makeChatUI(client));
                primaryStage.show();
            } catch (NumberFormatException e) {
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText("Invalid port number, try again");
            } catch (IllegalArgumentException e) {
                if (NAME_NOT_BE_NULL.equals(e.getMessage())) {
                    errorLabel.setTextFill(Color.RED);
                    errorLabel.setText("O campo nome é obrigatório!");
                }
            }

        });

        /*
         * Add the components to the root pane arguments are (Node, Column
         * Number, Row Number)
         */
        rootPane.add(nameField, 0, 0);
        rootPane.add(nameLabel, 1, 0);
        rootPane.add(submitClientInfoButton, 0, 3, 2, 1);
        rootPane.add(errorLabel, 0, 4);
        /* Make the Scene and return it */
        return new Scene(rootPane, 400, 400);
    }

    public Scene makeChatUI(Client client) {
        /* Make the root pane and set properties */
        GridPane rootPane = new GridPane();
        rootPane.setPadding(new Insets(5));
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);

        /*
         * Make the Chat's listView and set it's source to the Client's chatLog
         * ArrayList
         */


        ListView<String> chatListView = new ListView<>();
        retrieveServerMessages(userName, client, chatListView);

        /*
         * Make the chat text box and set it's action to send a message to the
         * server
         */
        TextField chatTextField = new TextField();
        chatTextField.setOnAction(event -> {
            client.writeToServer(userName, chatTextField.getText());
            retrieveServerMessages(userName, client, chatListView);
            chatTextField.clear();
        });

        /* Add the components to the root pane */
        rootPane.add(chatListView, 0, 0);
        rootPane.add(chatTextField, 0, 1);

        /* Make and return the scene */
        return new Scene(rootPane, 400, 400);

    }

    private void retrieveServerMessages(String userName, Client client, ListView<String> chatListView) {
        try {
            chatListView.setItems(client.retrieveMessage(userName));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
