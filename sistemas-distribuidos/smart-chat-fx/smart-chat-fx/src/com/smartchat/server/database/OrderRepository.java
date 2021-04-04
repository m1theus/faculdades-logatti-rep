package com.smartchat.server.database;

import com.smartchat.server.entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    List<Order> findByOrderDescription(final String description);

    List<Order> findByProductDescription(final String description);

    Order findByOrderId(final Long parseLong);
}
