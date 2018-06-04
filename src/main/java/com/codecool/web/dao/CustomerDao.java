package com.codecool.web.dao;

import com.codecool.web.model.Customer;

import java.sql.SQLException;

public interface CustomerDao {

    Customer findById(String customerId) throws SQLException;
}
