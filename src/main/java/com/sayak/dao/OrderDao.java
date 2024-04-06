package com.sayak.dao;

import com.sayak.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {
    Order findByOrderId(int orderId);

    List<Order> findAllByUserId(int userId);
}
