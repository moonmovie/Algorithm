package com.ssafy.product.service;
import java.sql.SQLException;

import com.ssafy.product.model.*;
public interface UserService {

	UsersDto login(String userid, String userpw) throws SQLException;
	
}
