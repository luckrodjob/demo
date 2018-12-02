package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.entity.User;

public interface IUserService {

	User findUser(String id);
	
	List<User> findUsers();
	
	User saveUser(User user);
	
	void deleteUser(String id);
}
