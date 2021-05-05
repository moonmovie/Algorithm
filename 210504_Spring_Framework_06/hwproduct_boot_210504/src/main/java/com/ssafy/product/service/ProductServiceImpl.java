package com.ssafy.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDao;
import com.ssafy.product.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).selectAll();
	}

	@Override
	public int updateOne(Product product) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).updateOne(product);
	}

	@Override
	public Product selectOne(String id) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).selectOne(id);
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).deleteOne(id);
	}

	@Override
	public int insertOne(Product product) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).insertOne(product);
	}

}
