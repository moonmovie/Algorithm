package com.ssafy.product.dao;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductDao {
	int insert(Product product);
	
	List<Product> selectAll();
}
