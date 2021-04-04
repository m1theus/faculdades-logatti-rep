package com.smartchat.server.database;

import com.smartchat.server.entity.Order;
import com.smartchat.server.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private final Connection dbConnection;

    public OrderRepositoryImpl() {
        this.dbConnection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Order> findAll() {
        try (PreparedStatement stmt = this.dbConnection
                .prepareStatement("select TB_O.id            as ORDER_ID, " +
                        "       TB_P.id            as PRODUCT_ID, " +
                        "       TB_O.description   as ORDER_DESCRIPTION, " +
                        "       TB_P.description   as PRODUCT_DESCRIPTION, " +
                        "       TB_P.type          as PRODUCT_TYPE, " +
                        "       TB_O.purchase_date as PURCHASE_DATE " +
                        "from TB_ORDER_ITEMS TOI " +
                        "         inner join TB_ORDERS TB_O on TOI.order_id = TB_O.id " +
                        "         inner join TB_PRODUCTS TB_P on TOI.product_id = TB_P.id " +
                        "ORDER BY TB_O.id;")) {

            final ResultSet resultSet = stmt.executeQuery();

            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()) {
                final Order order = buildOrder(resultSet, orderList);
                if (order != null) {
                    orderList.add(order);
                }
            }

            return orderList;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Order> findByOrderDescription(String description) {
        // TODO
        return null;
    }

    @Override
    public List<Order> findByProductDescription(String description) {
        // TODO
        return null;
    }

    @Override
    public Order findByOrderId(Long id) {
        // TODO
        final var orders = findAll();

        if (orders == null) {
            return null;
        }

        return orders.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Order buildOrder(ResultSet rs, List<Order> orderList) throws SQLException {
        if (rs == null) {
            return null;
        }

        if (orderList == null) {
            return null;
        }

        final var orderId = rs.getLong("ORDER_ID");

        Order order = orderList
                .stream()
                .filter(x -> x.getId() == orderId)
                .findFirst()
                .orElse(null);

        if (order == null) {
            order = new Order();
            order.setId(orderId);
            order.setDescription(rs.getString("ORDER_DESCRIPTION"));
            order.setPurchaseDate(rs.getDate("PURCHASE_DATE"));
        }

        if (order.getProducts() != null) {
            order.getProducts().add(new Product(
                    rs.getLong("PRODUCT_ID"),
                    rs.getString("PRODUCT_DESCRIPTION"),
                    rs.getString("PRODUCT_TYPE")));
        }

        return order;
    }
}
