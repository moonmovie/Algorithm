package com.ssafy.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dto.Product;
import com.ssafy.product.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductServic{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(Product product) {
		
		return sqlSession.getMapper(ProductRepo.class).insert(product);
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ProductRepo.class).selectAll();
	}
}
