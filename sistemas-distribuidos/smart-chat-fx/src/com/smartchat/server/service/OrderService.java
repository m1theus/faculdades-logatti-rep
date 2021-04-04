package com.smartchat.server.service;

import com.smartchat.server.Message;
import com.smartchat.server.database.OrderRepository;
import com.smartchat.server.database.OrderRepositoryImpl;
import com.smartchat.server.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    public static final String CHAT_BOT = "Tob";
    public static final String CONSULTA_PEDIDO = "Você quer consultar um pedido?";
    public static final String INFORME_NUMERO_PEDIDO = "Informe o número do pedido";
    private final OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepositoryImpl();
    }

    public void sendMessage(final Message entity) {
        if (entity.getMessage().contains("meu pedido")
                || entity.getMessage().contains("pedido")
                || entity.getMessage().contains("comprei um")
                || entity.getMessage().contains("pedido de um")) {
            Message.setMessage(new Message(CHAT_BOT, CONSULTA_PEDIDO));
        }

        if ("bot".equals(entity.getMessage())) {
            Message.setMessage(new Message(CHAT_BOT, "meu nome é Tob!!!!"));
        }

        final var lastBotMessage = lastBotMessage();
        if (lastBotMessage != null && "Informe apenas o número do pedido".equals(lastBotMessage.getMessage())
                || lastBotMessage != null && INFORME_NUMERO_PEDIDO.equals(lastBotMessage.getMessage())) {

            try {
                final var orderId = Long.parseLong(entity.getMessage());
                final var order = orderRepository.findByOrderId(orderId);
                if (order == null) {
                    Message.setMessage(new Message(CHAT_BOT, "Você não possui pedidos!"));
                } else {
                    var botMessage = "Seu pedido " + order.getId() + " possui os produtos: " + order.getProducts().stream().map(Product::getDescription).collect(Collectors.joining(", "));
                    Message.setMessage(new Message(CHAT_BOT, botMessage));
                }
            } catch (final NumberFormatException e) {
                Message.setMessage(new Message(CHAT_BOT, "Informe apenas o número do pedido"));
            }
        }

        if (entity.getMessage().contains("sim")
                && CHAT_BOT.equals(lastMessage().getAuthor())
                && CONSULTA_PEDIDO.equals(lastMessage().getMessage())) {

            final var orders = orderRepository.findAll();

            String botMessage = "";

            if (orders == null || orders.isEmpty()) {
                botMessage += "Você não possui pedidos!";
            } else {
                botMessage += INFORME_NUMERO_PEDIDO;
            }

            Message.setMessage(new Message(CHAT_BOT, botMessage));
        }



        Message.setMessage(entity);
    }

    public List<Message> retrieveMessage() {
        return Message.retrieveMessages()
                .stream()
                .sorted(Comparator.comparing(Message::getDateAt))
                .collect(Collectors.toList());
    }

    public Message lastMessage() {
        return retrieveMessage()
                .stream()
                .filter(x -> x.getDateAt() != null)
                .max(Comparator.comparing(Message::getDateAt))
                .orElse(null);
    }

    public Message lastBotMessage() {
        return retrieveMessage()
                .stream()
                .filter(x -> x.getDateAt() != null && CHAT_BOT.equals(x.getAuthor()))
                .max(Comparator.comparing(Message::getDateAt))
                .orElse(null);
    }
}
