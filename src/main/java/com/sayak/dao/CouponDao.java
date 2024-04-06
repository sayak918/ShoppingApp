package com.sayak.dao;

import com.sayak.Entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDao extends JpaRepository<Coupon,String> {

}
