package com.sayak.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "payment_status")
public class PaymentStatus {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "user_id")
    private int userId;
    @Column(name = "amount")
    private int amt;
    @Column(name = "coupon_id")
    private String coupon;
    @Column(name = "date")
    private String date;
    @Column(name="status")
    private String status;

    public PaymentStatus() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

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

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentStatus(String transactionId, int orderId, int userId, int amt, String coupon, String date, String status) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.userId = userId;
        this.amt = amt;
        this.coupon = coupon;
        this.date = date;
        this.status = status;
    }
}
