package com.thonline.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.thonline.test.model.User;
import com.thonline.test.service.UserService;

public class UserServiceImpl implements UserService {

	private static List<User> users = null;

	public UserServiceImpl() {
		if (users == null) {
			prepareData();
		}
	}

	private void prepareData() {
		users = new ArrayList<User>();
		users.add(new User("Alan", "Student", 20));
		users.add(new User("Tom", "Writer", 45));
		users.add(new User("Eric", "Doctor", 30));
		users.add(new User("David", "Student", 22));
		users.add(new User("Mark", "Writer", 35));
		users.add(new User("Jboss", "Doctor", 40));
	}

	public List<User> getAll() {
		return users;
	}

	public List<User> search(String name) {
		List<User> filterUsers = new ArrayList<User>();
		for (User user : users) {
			if (user.getName().startsWith(name)) {
				filterUsers.add(user);
			}
		}
		return filterUsers;
	}
}
