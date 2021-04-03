package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "ssafy";
	private static final String PASSWORD = "ssafy";
	
	// 어차피 안될것이다 왜냐면 우리는 객체 생성을 안할거거든 ㅋ
	// new로 객체가 계속 생성될것이다.
	//static 블럭을 사용한다 static 블럭은 한번만 초기화 되거든
//	public DBUtil() { //원래는 이게 맞지만 흐음 자바 일정 버전 이상에서부터 VM이 찾아주더라
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	// 클래스 생성시 한번만 로드된다
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	// 매개변수의 공통점은 뭘까 autocloserable 이 implements 되어있다
//	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
//		try {
//			if(rs!=null)
//				rs.close();
//			if(pstmt != null)
//				pstmt.close();
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void close( PreparedStatement pstmt, Connection conn) {
//		try {
//			if(pstmt != null)
//				pstmt.close();
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void close(AutoCloseable closeables) {
//		
//			try {
//				if(closeables != null)
//				closeables.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	public static void close(AutoCloseable... closeables) {
		
		try {
			for(AutoCloseable a : closeables) {
				if(a !=null) {
					a.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
