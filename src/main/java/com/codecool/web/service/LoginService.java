package com.codecool.web.service;

import com.codecool.web.model.Customer;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface LoginService {

    Customer loginCustomer(String customerId) throws SQLException, ServiceException;
}
