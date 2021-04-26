package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Service(value = "pdtService")
public class ProductServicelmpl implements ProductService{
	@Autowired
	private ProductRepo productRepo;
	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return productRepo.selectAll();
	}

	@Override
	public Product select(String id) {
		return productRepo.select(id);
	}

	@Override
	public int insert(Product product) {
		// TODO Auto-generated method stub
		return productRepo.insert(product);
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return productRepo.update(product);
	}

	@Override
	public int delete(String id) {
		return productRepo.delete(id);
	}

}
