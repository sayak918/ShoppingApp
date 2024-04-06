package com.sayak;

public class WebOrderHistory {
    private int orderId;
    private int amount;
   private String date;
   private String coupon;
   private String transaction;
   private String status;

    public WebOrderHistory(int orderId, int amount, String date, String coupon, String transaction, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.date = date;
        this.coupon = coupon;
        this.transaction = transaction;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
