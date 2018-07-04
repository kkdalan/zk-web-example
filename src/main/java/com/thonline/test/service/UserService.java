package com.thonline.test.service;

import java.util.ArrayList;
import java.util.List;

import com.thonline.test.model.User;

public class UserService {
	
	private List<User> users = new ArrayList<User>();
	
	public UserService() {
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
		for(User user : users) {
			if(user.getName().contains(name)) {
				filterUsers.add(user);
			}
		}
		return filterUsers;
	}
}
