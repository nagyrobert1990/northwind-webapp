package com.codecool.web.servlet;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.dao.database.DatabaseCustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            CustomerDao customerDao = new DatabaseCustomerDao(connection);
            LoginService loginService = new SimpleLoginService(customerDao);

            String customerId = req.getParameter("customerId");

            Customer customer = loginService.loginCustomer(customerId);
            req.getSession().setAttribute("customer", customer);

            sendMessage(resp, HttpServletResponse.SC_OK, customer);
        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
