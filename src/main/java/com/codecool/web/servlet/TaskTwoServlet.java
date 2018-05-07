package com.codecool.web.servlet;


import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DatabaseTaskDao;
import com.codecool.web.model.TaskModel;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task2")
public class TaskTwoServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DatabaseTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            String numOfProducts = req.getParameter("filter");

            if (numOfProducts == null || numOfProducts.equals("")) {
                List<TaskModel> result = taskService.getTaskTwoResults();
                req.setAttribute("result", result);
            } else {
                List<TaskModel> filteredResult = taskService.getTaskTwoFilteredResults(Integer.parseInt(numOfProducts));
                req.setAttribute("result", filteredResult);
            }
        } catch (SQLException | ServiceException e) {
            req.setAttribute("error", e.getMessage());
        }
        req.getRequestDispatcher("task2.jsp").forward(req,resp);
    }
}
