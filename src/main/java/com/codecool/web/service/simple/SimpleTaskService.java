package com.codecool.web.service.simple;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskModel;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTaskService implements TaskService {

    private final TaskDao taskDao;

    public SimpleTaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskModel> getTaskOneResults() throws ServiceException, SQLException {
        try {
            List<TaskModel> result = taskDao.findTaskOneResults();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskOneFilteredResults(String company) throws ServiceException, SQLException {
        try {
            List<TaskModel> result = taskDao.findProductByCompany(company);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskTwoResults() throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findTaskTwoResults();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskTwoFilteredResults(int numOfProducts) throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findCompanyByNumberOfProducts(numOfProducts);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskThreeResults() throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findTaskThreeResults();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskThreeFilteredResults(String company) throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findCompanyByName(company);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskFourResults() throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findTaskFourResults();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskFourFilteredResults(String customerName) throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findOrderIdsByCustomerName(customerName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskFiveResults() throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findTaskFiveResults();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<TaskModel> getTaskFiveFilteredResults(float price) throws ServiceException {
        try {
            List<TaskModel> result = taskDao.findCheaperProducts(price);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }
}
