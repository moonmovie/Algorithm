package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductService {
	List<Product> selectAll();
	int updateOne(Product prodct);
	Product selectOne(String id);
	int deleteOne(String id);
	int insertOne(Product product);
	
}
