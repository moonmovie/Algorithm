package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductService {
	int insert(Product product);
	
	List<Product> selectAll();
}
