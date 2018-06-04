package com.codecool.web.service.simple;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public final class SimpleLoginService implements LoginService {

    private final CustomerDao customerDao;

    public SimpleLoginService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer loginCustomer(String customerId) throws SQLException, ServiceException {
        try {
            Customer customer = customerDao.findById(customerId);
            if (customer == null) {
                throw new ServiceException("Bad login");
            }
            return customer;
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
