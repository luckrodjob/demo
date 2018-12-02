package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IUserDao;
import com.example.demo.dao.entity.User;

@Service
@Transactional
public class UserServiceImp implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(propagation=  Propagation.SUPPORTS,readOnly=true)
	public User findUser(String id) {
		Optional<User> optionalUser= userDao.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}

	@Override
	@Transactional(propagation=  Propagation.SUPPORTS,readOnly=true)
	public List<User> findUsers() {
		return userDao.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteById(id);		
	}

}
