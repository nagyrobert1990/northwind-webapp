package com.codecool.web.dao.database;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCustomerDao extends AbstractDao implements CustomerDao {

    public DatabaseCustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(String customerId) throws SQLException {
        if (customerId == null || "".equals(customerId)) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        String sql = "SELECT customer_id FROM customers WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customerId);
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    return fetchCustomer(resultSet);
                }
            }
        }
        return null;
    }

    private Customer fetchCustomer(ResultSet resultSet) throws SQLException {
        String customerId = resultSet.getString("customer_id");
        String companyName = resultSet.getString("company_name");
        String contactName = resultSet.getString("contact_name");
        String contactTitle = resultSet.getString("contact_title");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String region = resultSet.getString("region");
        String postalCode = resultSet.getString("postal_code");
        String country = resultSet.getString("country");
        String phone = resultSet.getString("phone");
        String fax = resultSet.getString("fax");
        return new Customer(customerId, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
    }
}