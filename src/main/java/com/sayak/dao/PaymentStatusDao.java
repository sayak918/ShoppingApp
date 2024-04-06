package com.sayak.dao;

import com.sayak.Entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentStatusDao extends JpaRepository<PaymentStatus,String> {
    List<PaymentStatus> findAllByUserId(int userId);
}
