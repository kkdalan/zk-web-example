package com.thonline.test.resolver;

import com.thonline.test.service.UserService;

public class UserResolver implements org.zkoss.xel.VariableResolver {
	
    public Object resolveVariable(String name) {
        return "users".equals(name) ? new UserService().getAll(): null;
    }
}
