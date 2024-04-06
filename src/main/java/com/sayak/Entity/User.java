package com.sayak.Entity;


import jakarta.persistence.*;



@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @Column(name = "no_coupon")
    private int noOfCoupon;

    @Column(name = "coupon_id")
    private String couponId;

    public User() {
    }


    public User(int id, String name, String email, int noOfCoupon, String couponId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.noOfCoupon = noOfCoupon;
        this.couponId = couponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfCoupon() {
        return noOfCoupon;
    }

    public void setNoOfCoupon(int noOfCoupon) {
        this.noOfCoupon = noOfCoupon;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
