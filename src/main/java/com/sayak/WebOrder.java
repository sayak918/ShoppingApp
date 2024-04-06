package com.sayak;

public class WebOrder {
    private int orderId;
    private int amount;

    private String coupon;

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



    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public WebOrder(int orderId, int amount,  String coupon) {
        this.orderId = orderId;
        this.amount = amount;

        this.coupon = coupon;
    }
}
