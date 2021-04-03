package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.ssafy.product.model.ProductDto;
import com.ssafy.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	private static ProductDaoImpl productdao;
	
	private  ProductDaoImpl() {}
	
	public static ProductDaoImpl getProductDao() {
		if(productdao==null)
			productdao = new ProductDaoImpl();
		return productdao;
	}
	@Override
	public List<ProductDto> productList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> list  = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select * from product";
			
			pstmt = conn.prepareStatement(sql);

			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			
			ProductDto stuff=null;
			while(rs.next()) {
				stuff = new ProductDto();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
				list.add(stuff);
			}
			
		} finally {
			DBUtil.close(rs, conn, pstmt);
		}
		return list;
	}

	@Override
	public ProductDto lastproductList(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto stuff=null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select * from product \n";
			sql+="where adder = ?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			
			while(rs.next()) {
				stuff = new ProductDto();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
			}
			
		}finally {
			DBUtil.close(rs, conn, pstmt);
		}
		
		return stuff;
	}

	@Override
	public List<ProductDto> searchProduct(String key, String word) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		List<ProductDto> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			
			if(key.equals("상품명")) {
				sql += "select * from product \n";
				sql += "where name = ?" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
			}else {
				sql += "select * from product \n";
				sql += "where  price < " + word;
				pstmt = conn.prepareStatement(sql);
			}
			
			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			
			ProductDto stuff=null;
			
			while(rs.next()) {
				stuff = new ProductDto();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
				list.add(stuff);
			}
			System.out.println(list);
		} finally {
			DBUtil.close(rs, conn, pstmt);
		}
		return list;
	}
	
	@Override
	public void insertProduct(ProductDto product) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		try {
			conn = DBUtil.getConnect();
			String sql = "insert into product (id, name, price, des, adder, date) \n";
			sql+="values(?,?,?,?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getPrice());
			pstmt.setString(4, product.getDes());
			pstmt.setString(5, product.getAdder());
			rs =pstmt.executeUpdate();
			System.out.println(rs);
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
	}

	@Override
	public int deleteDao(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from product where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs =pstmt.executeUpdate();
			System.out.println(rs);
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
		System.out.println(rs);
		return rs;
	}

	@Override
	public void updateDao(ProductDto product) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		try {
			conn = DBUtil.getConnect();
			String sql = "update product set name = ?, price = ?, des = ?, date=now() \n";
			sql+="where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getPrice());
			pstmt.setString(3, product.getDes());
			pstmt.setString(4, product.getId());
			
			rs =pstmt.executeUpdate();
			System.out.println(rs);
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
	}
	
}
