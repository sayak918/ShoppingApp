package com.sayak.Service;

import com.sayak.Entity.Coupon;
import com.sayak.dao.CouponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    CouponDao couponDao;

    @Autowired
    public CouponService(CouponDao couponDao) {
        this.couponDao = couponDao;
    }


    public List<Coupon> findAll() {
      return   couponDao.findAll();
    }
    public Coupon findCoupon(String coupon){
        return couponDao.findById(coupon).get();
    }

}
