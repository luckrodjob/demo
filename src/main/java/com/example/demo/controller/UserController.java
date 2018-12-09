package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.entity.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/clean", method= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
	@ResponseBody
	public String  clearAllUsers() {
		userService.deleteAllUsers();
		return "success";
	}
	
	@RequestMapping(value="/{id}", method= {RequestMethod.GET,RequestMethod.DELETE})
	@ResponseBody
	public User findUser(@PathVariable(name= "id")String userId,HttpServletRequest request) {
		User user = null;
		if(RequestMethod.GET.toString().equalsIgnoreCase(request.getMethod())) {
			user = userService.findUser(userId);
		}else {
			System.out.println("23");
			user =  userService.findUser(userId);
			userService.deleteUser(userId);
		}
		return user;
		
	}
	
	@RequestMapping(value= "/list",method= {RequestMethod.GET})
	@ResponseBody
	public List<User> findUsers() {
		List<User> users = userService.findUsers();
		return users;
		
	}
	
	@RequestMapping(value ="/update",method= {RequestMethod.POST,RequestMethod.PUT})
	@ResponseBody
	public User  updateUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
}
