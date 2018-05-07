package com.codecool.web.service;

import com.codecool.web.model.TaskModel;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    List<TaskModel> getTaskOneResults() throws ServiceException, SQLException;
    List<TaskModel> getTaskOneFilteredResults(String companyName) throws ServiceException, SQLException;
    List<TaskModel> getTaskTwoResults() throws ServiceException;
    List<TaskModel> getTaskTwoFilteredResults(int numOfProducts) throws ServiceException;
    List<TaskModel> getTaskThreeResults() throws ServiceException;
    List<TaskModel> getTaskThreeFilteredResults(String companyName) throws ServiceException;
    List<TaskModel> getTaskFourResults() throws ServiceException;
    List<TaskModel> getTaskFourFilteredResults(String companyName) throws ServiceException;
    List<TaskModel> getTaskFiveResults() throws ServiceException;
    List<TaskModel> getTaskFiveFilteredResults(float price) throws ServiceException;
}
