package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User,String>{

}
