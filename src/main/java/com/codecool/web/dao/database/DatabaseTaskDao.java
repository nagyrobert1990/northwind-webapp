package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTaskDao extends AbstractDao implements TaskDao {

    public DatabaseTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<TaskModel> findTaskOneResults() throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT ProductName AS Product, CompanyName AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "ORDER BY ProductName, CompanyName;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                result.add(fetchTaskOne(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findProductByCompany(String company) throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT ProductName AS Product, CompanyName AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "WHERE suppliers.companyname=? " +
                "ORDER BY ProductName, CompanyName;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    result.add(fetchTaskOne(resultSet));
                }
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findTaskTwoResults() throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company, COUNT(ProductName) AS NumberOfProducts " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY CompanyName " +
                "ORDER BY NumberOfProducts, CompanyName;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskTwo(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findCompanyByNumberOfProducts(int numOfProducts) throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company, COUNT(ProductName) AS NumberOfProducts " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY CompanyName " +
                "HAVING COUNT(products.supplierid) = ? " +
                "ORDER BY NumberOfProducts, CompanyName;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, numOfProducts);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchTaskTwo(resultSet));
                }
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findTaskThreeResults() throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY CompanyName " +
                "HAVING COUNT(ProductName) = 5 " +
                "ORDER BY CompanyName;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskThree(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findCompanyByName(String company) throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY CompanyName " +
                "HAVING COUNT(ProductName) = 5 AND CompanyName=?" +
                "ORDER BY CompanyName;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchTaskThree(resultSet));
                }
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findTaskFourResults() throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT customers.companyname AS company, array_to_string " +
                "(array_agg(orders.orderid), ',') AS orderid FROM customers " +
                "JOIN orders ON customers.customerid = orders.customerid " +
                "GROUP BY customers.companyname " +
                "ORDER BY companyname;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskFour(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findOrderIdsByCustomerName(String customerName) throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT customers.companyname AS company, array_to_string " +
                "(array_agg(orders.orderid), ',') AS orderid FROM customers " +
                "JOIN orders ON customers.customerid = orders.customerid " +
                "GROUP BY customers.companyname " +
                "HAVING customers.companyname=? " +
                "ORDER BY companyname;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customerName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchTaskFour(resultSet));
                }
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findTaskFiveResults() throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company, ProductName AS Product, UnitPrice AS Price " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products WHERE suppliers.supplierid = products.supplierid) " +
                "ORDER BY UnitPrice DESC, ProductName, CompanyName;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskFive(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<TaskModel> findCheaperProducts(float price) throws SQLException {
        List<TaskModel> result = new ArrayList<>();
        String sql = "SELECT CompanyName AS Company, ProductName AS Product, UnitPrice AS Price " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "WHERE UnitPrice = " +
                "(SELECT MAX(UnitPrice) FROM products " +
                "WHERE suppliers.supplierid = products.supplierid " +
                "HAVING MAX(products.unitprice)<?) " +
                "ORDER BY UnitPrice DESC, ProductName, CompanyName;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, price);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(fetchTaskFive(resultSet));
                }
            }
        }
        return result;
    }

    private TaskModel fetchTaskOne(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String product = resultSet.getString("product");
        return new TaskModel(company, product, null);
    }

    private TaskModel fetchTaskTwo(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        int numberOfProducts = resultSet.getInt("numberofproducts");
        return new TaskModel(company, numberOfProducts);
    }

    private TaskModel fetchTaskThree(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new TaskModel(company);
    }

    private TaskModel fetchTaskFour(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String orderIds = resultSet.getString("orderid");
        return new TaskModel(company, null ,orderIds);
    }

    private TaskModel fetchTaskFive(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String product = resultSet.getString("product");
        int price = resultSet.getInt("price");
        return new TaskModel(company, product, price);
    }
}
