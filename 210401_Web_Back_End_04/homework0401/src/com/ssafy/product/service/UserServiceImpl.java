package com.ssafy.product.service;

import java.sql.SQLException;

import com.ssafy.product.dao.UsersDaoImpl;
import com.ssafy.product.model.UsersDto;

public class UserServiceImpl implements UserService {
	private static UserServiceImpl userService;
	private UserServiceImpl() {}
	
	public static UserServiceImpl getUserService() {
		if(userService==null)
			userService = new UserServiceImpl();
		return userService;
	}
	
	
	@Override
	public UsersDto login(String userid, String userpw) throws SQLException{
		
		return UsersDaoImpl.getUserDao().login(userid, userpw);
	}

}
