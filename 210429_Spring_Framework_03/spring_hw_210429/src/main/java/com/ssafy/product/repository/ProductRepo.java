package com.ssafy.product.repository;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductRepo {
	int insert(Product product);
	
	List<Product> selectAll();
}
