package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.product.model.UsersDto;
import com.ssafy.util.DBUtil;

public class UsersDaoImpl implements UsersDao{
	
	private static UsersDaoImpl userDao;
	
	private UsersDaoImpl() {
	}
	
	public static UsersDaoImpl getUserDao() {
		if(userDao==null)
			userDao = new UsersDaoImpl();
		return userDao;
	}
	
	@Override
	public UsersDto login(String userid, String userpw) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UsersDto user=null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select userid, username, email \n";
			sql+="from users \n";
			sql+="where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			
			rs =pstmt.executeQuery();
			if(rs.next()) {
				user = new UsersDto();
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setUserId(rs.getString("userid"));
			}
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return user;
	}
	
}
