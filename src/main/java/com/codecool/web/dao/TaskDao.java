package com.codecool.web.dao;

import com.codecool.web.model.TaskModel;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {

    List<TaskModel> findTaskOneResults() throws SQLException;
    List<TaskModel> findProductByCompany(String company) throws SQLException;
    List<TaskModel> findTaskTwoResults() throws SQLException;
    List<TaskModel> findCompanyByNumberOfProducts(int numOfProducts) throws SQLException;
    List<TaskModel> findTaskThreeResults() throws SQLException;
    List<TaskModel> findCompanyByName(String company) throws SQLException;
    List<TaskModel> findTaskFourResults() throws SQLException;
    List<TaskModel> findOrderIdsByCustomerName(String customerName) throws SQLException;
    List<TaskModel> findTaskFiveResults() throws SQLException;
    List<TaskModel> findCheaperProducts(float price) throws SQLException;
}