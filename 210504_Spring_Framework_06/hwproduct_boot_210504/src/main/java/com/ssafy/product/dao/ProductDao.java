package com.ssafy.product.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.product.dto.Product;

public interface ProductDao {
	List<Product> selectAll(Map <String, Integer> mmap);
	int updateOne(Product prodct);
	Product selectOne(String id);
	int deleteOne(String id);
	int insertOne(Product product);
	int totalpage();
}
