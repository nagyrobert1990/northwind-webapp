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

@WebServlet("/task5")
public class TaskFiveServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DatabaseTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            String price = req.getParameter("filter");
            if (price == null || price.equals("")) {
                List<TaskModel> result = taskService.getTaskFiveResults();
                req.setAttribute("result", result);
            } else {
                List<TaskModel> filteredResult = taskService.getTaskFiveFilteredResults(Float.parseFloat(price));
                req.setAttribute("result", filteredResult);
            }
        } catch (SQLException | ServiceException e) {
            req.setAttribute("error", e.getMessage());
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }
}
