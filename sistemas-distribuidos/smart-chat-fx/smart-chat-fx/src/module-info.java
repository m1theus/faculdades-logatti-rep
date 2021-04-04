module smart.chat.fx {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.rmi;
    requires java.sql;

    exports com.smartchat.server;

    opens com.smartchat.client;
}