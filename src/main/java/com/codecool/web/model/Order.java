package com.codecool.web.model;

import java.sql.Timestamp;

public class Order {

    private final int orderId;
    private final Timestamp orderDate;
    private final Timestamp requiredDate;
    private final Timestamp shippedDate;
    private final int shipVia;
    private final int freight;
    private final String shipName;
    private final String shipAddress;
    private final String shipCity;
    private final String shipRegion;
    private final String shipPostalCode;
    private final String shipCountry;

    public Order(int orderId, Timestamp orderDate, Timestamp requiredDate, Timestamp shippedDate, int shipVia, int freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public int getOrderId() {
        return orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public Timestamp getRequiredDate() {
        return requiredDate;
    }

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public int getShipVia() {
        return shipVia;
    }

    public int getFreight() {
        return freight;
    }

    public String getShipName() {
        return shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }
}