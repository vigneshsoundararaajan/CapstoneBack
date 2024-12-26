package com.example.order_service.entity;

public class OrderBuilder {
    private Long id;
    private String productName;
    private int quantity;
    private double price;

    public OrderBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public OrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setId(this.id);
        order.setProductName(this.productName);
        order.setQuantity(this.quantity);
        order.setPrice(this.price);
        return order;
    }
}

