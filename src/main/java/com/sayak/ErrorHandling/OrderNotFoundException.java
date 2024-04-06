package com.sayak.ErrorHandling;

public class OrderNotFoundException {
    private int orderId;
    private String description;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderNotFoundException(int orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }
}
