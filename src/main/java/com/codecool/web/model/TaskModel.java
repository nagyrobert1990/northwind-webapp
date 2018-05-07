package com.codecool.web.model;

public class TaskModel {

    private String company;
    private String product;
    private int numOfProducts;
    private String orderId;
    private int price;

    public TaskModel(String company) {
        this.company = company;
    }

    public TaskModel(String company, int numOfProducts) {
        this.company = company;
        this.numOfProducts = numOfProducts;
    }

    public TaskModel(String company, String product, String orderId) {
        this.company = company;
        this.product = product;
        this.orderId = orderId;
    }

    public TaskModel(String company, String product, int price) {
        this.company = company;
        this.product = product;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getProduct() {
        return product;
    }

    public int getNumOfProducts() {
        return numOfProducts;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getPrice() {
        return price;
    }
}
