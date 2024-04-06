package com.sayak.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amount")
    private int amount;
    @Column(name = "coupon_id")
    private String couponId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Order() {
    }

    public Order(int userId, int quantity, int amount, String couponId) {
        this.userId = userId;
        this.quantity = quantity;
        this.amount = amount;
        this.couponId = couponId;
    }
}
