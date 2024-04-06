package com.sayak.ErrorHandling;

public class PaymentResponse {
    private int userId;
    private int orderId;
    private String transactionId;
    private String status;
    private String description;

    public PaymentResponse(int userId, int orderId, String transactionId, String status) {
        this.userId = userId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.status = status;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentResponse() {
    }

    public PaymentResponse(int userId, int orderId, String transactionId, String status, String description) {
        this.userId = userId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.status = status;
        this.description = description;
    }
}
