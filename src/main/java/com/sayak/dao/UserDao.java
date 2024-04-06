package com.sayak.dao;

import com.sayak.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {


}
