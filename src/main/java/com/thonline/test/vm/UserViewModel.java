package com.thonline.test.vm;

import java.util.List;

import com.thonline.test.model.User;
import com.thonline.test.service.UserService;
import com.thonline.test.service.impl.UserServiceImpl;

public class UserViewModel {
	
	private UserService userService = new UserServiceImpl();
	
	public List<User> getUsers() {
		List<User> users = userService.getAll();
		return users;
	}
}