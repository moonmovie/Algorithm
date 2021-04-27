package com.ssafy.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDaoImpl;
import com.ssafy.product.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDaoImpl productDao;
	
	@Override
	public int insert(Product product) {
		// TODO Auto-generated method stub
		return productDao.insert(product);
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

}
