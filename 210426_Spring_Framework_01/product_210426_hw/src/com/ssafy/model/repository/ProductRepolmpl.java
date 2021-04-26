package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

@Repository
public class ProductRepolmpl implements ProductRepo {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Product> selectAll() {
		Product pd = null;
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		List<Product> list = new LinkedList<Product>();
		try {
			String sql="select pid,pname,price,des from productsts";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pd = new Product();
				pd.setId(rs.getString("pid"));
				pd.setName(rs.getString("pname"));
				pd.setPrice(rs.getString("price"));
				pd.setDescription(rs.getString("des"));
				list.add(pd);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pstmt,rs);
		}
		
		return list;
	}

	@Override
	public Product select(String id) {
		Product pd = null;
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			String sql="select pid,pname,price,des from productsts where pid=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pd = new Product();
				pd.setId(rs.getString("pid"));
				pd.setName(rs.getString("pname"));
				pd.setPrice(rs.getString("price"));
				pd.setDescription(rs.getString("des"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return pd;
	}

	@Override
	public int insert(Product product) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		int rs =-1;
		try {
			String sql="insert into productsts (pid, pname, price, des) values(?,?,?,?)";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			
			rs = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pstmt);
		}
		
		return rs;
	}

	@Override
	public int update(Product product) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		int rs =-1;
		try {
			String sql="update productsts set pname=?, price=?, des=? where pid=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getId());
			
			rs = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pstmt);
		}
		
		return rs;
	}

	@Override
	public int delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		int rs =-1;
		try {
			String sql="delete from productsts where pid=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,pstmt);
		}
		return rs;
	}

}
