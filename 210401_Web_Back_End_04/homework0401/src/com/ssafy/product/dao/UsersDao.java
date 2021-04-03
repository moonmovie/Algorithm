package com.ssafy.product.dao;

import java.sql.SQLException;

import com.ssafy.product.model.UsersDto;

public interface UsersDao {

	UsersDto login(String userid, String userpw) throws SQLException;
}
