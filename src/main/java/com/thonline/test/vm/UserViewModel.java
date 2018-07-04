package com.thonline.test.vm;

import java.util.List;

import com.thonline.test.model.User;
import com.thonline.test.service.UserService;

public class UserViewModel {
	
	public List<User> getUsers() {
		List<User> users = new UserService().getAll();
		return users;
	}
}