package com.ssafy.product.service;

import java.util.List;
import java.util.Map;

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
	public List<Product> selectAll(Map <String, Integer> mmap) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).selectAll(mmap);
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

	@Override
	public int totalpage() {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(ProductDao.class).totalpage();
	}

}
