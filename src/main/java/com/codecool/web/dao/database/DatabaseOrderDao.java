package com.codecool.web.dao.database;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderDao extends AbstractDao implements OrderDao {

    public DatabaseOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> findOrdersByCustomerId(String customerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT order_id FROM orders WHERE customer_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders.add(fetchCustomer(resultSet));
                }
            }
        }
        return orders;
    }

    private Order fetchCustomer(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("order_id");
        Timestamp orderDate = resultSet.getTimestamp("order_date");
        Timestamp requiredDate = resultSet.getTimestamp("required_date");
        Timestamp shippedDate = resultSet.getTimestamp("shipped_date");
        int shipVia = resultSet.getInt("ship_via");
        int freight = resultSet.getInt("freight");
        String shipName = resultSet.getString("ship_name");
        String shipAddress = resultSet.getString("ship_address");
        String shipCity = resultSet.getString("ship_city");
        String shipRegion = resultSet.getString("ship_region");
        String shipPostalCode = resultSet.getString("ship_postal_code");
        String shipCountry = resultSet.getString("ship_country");
        return new Order(orderId, orderDate, requiredDate, shippedDate, shipVia, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
    }
}