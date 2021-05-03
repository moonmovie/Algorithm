package com.ssafy.book.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dto.User;
import com.ssafy.book.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public User login(User user) {
		return sqlsession.getMapper(UserRepo.class).login(user);
	}

}
