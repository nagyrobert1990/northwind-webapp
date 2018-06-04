package com.codecool.web.dao.database;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProdutctDao extends AbstractDao implements ProductDao {

    public DatabaseProdutctDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> findAllProducts() throws SQLException {
        String sql = "SELECT product_id, " +
                "product_name, " +
                "unit_price, units_in_stock, " +
                "(SELECT category_name FROM categories WHERE category_id = products.category_id) AS cat_name, " +
                "(SELECT company_name FROM suppliers WHERE supplier_id = products.supplier_id) AS sup_name " +
                "FROM products;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(fetchCustomer(resultSet));
            }
            return products;
        }
    }

    private Product fetchCustomer(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("product_id");
        String productName = resultSet.getString("product_name");
        int supplierId = resultSet.getInt("supplier_id");
        int categoryId = resultSet.getInt("category_id");
        String quantityPerUnit = resultSet.getString("quantity_per_unit");
        int unitPrice = resultSet.getInt("unit_price");
        int unitsInStock = resultSet.getInt("units_in_stock");
        int unitsOnOrder = resultSet.getInt("units_on_order");
        int reorderLevel = resultSet.getInt("reorder_level");
        int discontinued = resultSet.getInt("discontinued");
        return new Product(productId, productName, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);
    }
}