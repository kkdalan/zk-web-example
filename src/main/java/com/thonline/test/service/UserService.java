package com.thonline.test.service;

import java.util.List;

import com.thonline.test.model.User;

public interface UserService {
	
	public List<User> getAll();
	
	public List<User> search(String name);
}
