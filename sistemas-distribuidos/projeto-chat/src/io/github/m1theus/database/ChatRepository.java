package io.github.m1theus.database;

import io.github.m1theus.entity.ChatEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRepository {

    private final Connection connection;

    public ChatRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean insert(ChatEntity entity) throws SQLException {

        try {
            try (PreparedStatement stmt = this.connection
                    .prepareStatement("INSERT INTO TB_CHAT (author, message) values (?, ?)")) {

                stmt.setString(1, entity.getAuthor());
                stmt.setString(2, entity.getMessage());

                return stmt.execute();
            }
        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
    }

    public List<ChatEntity> findAll() throws SQLException {
        try (PreparedStatement stmt = this.connection
                .prepareStatement("SELECT ID, AUTHOR, MESSAGE FROM TB_CHAT")) {

            final ResultSet resultSet = stmt.executeQuery();

            List<ChatEntity> chatEntities = new ArrayList<>();
            while (resultSet.next()) {
                chatEntities.add(new ChatEntity(resultSet.getLong("id"), resultSet.getString("author"), resultSet.getString("message")));
            }

            return chatEntities;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return Collections.emptyList();
    }
}
