package com.thonline.test.resolver;

import com.thonline.test.service.UserService;
import com.thonline.test.service.impl.UserServiceImpl;

public class UserResolver implements org.zkoss.xel.VariableResolver {
	
	private UserService userService = new UserServiceImpl();
	
    public Object resolveVariable(String name) {
        return "users".equals(name) ? userService.getAll(): null;
    }
}
