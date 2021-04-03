package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductService {
	
	List<ProductDto> productList() throws SQLException;
	
	ProductDto lastproductList(String id) throws SQLException;
	
	List<ProductDto> searchProduct(String key, String word) throws SQLException;
	
	public void insertProduct(ProductDto product) throws SQLException;
	
	public int deleteProduct(String id) throws SQLException;
	
	public void updateProduct(ProductDto product) throws SQLException;
}
