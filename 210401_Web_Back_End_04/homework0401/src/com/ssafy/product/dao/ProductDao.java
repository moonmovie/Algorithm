package com.ssafy.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductDao {
	List<ProductDto> productList() throws SQLException;
	
	ProductDto lastproductList(String id) throws SQLException;
	
	List<ProductDto> searchProduct(String key, String word) throws SQLException;
	
	public void insertProduct(ProductDto product) throws SQLException;
	
	public int deleteDao(String id) throws SQLException;
	
	public void updateDao(ProductDto product) throws SQLException;
	
}
