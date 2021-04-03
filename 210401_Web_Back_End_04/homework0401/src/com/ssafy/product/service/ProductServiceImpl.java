package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.dao.ProductDaoImpl;
import com.ssafy.product.model.ProductDto;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl productservice;
	
	private ProductServiceImpl() {
	}
	
	public static ProductServiceImpl getproductservice() {
		if(productservice==null)
			productservice = new ProductServiceImpl();
		return productservice;
	}
	@Override
	public List<ProductDto> productList() throws SQLException {
		return ProductDaoImpl.getProductDao().productList();
	}

	@Override
	public ProductDto lastproductList(String id) throws SQLException {
		
		return ProductDaoImpl.getProductDao().lastproductList(id);
	}

	@Override
	public List<ProductDto> searchProduct(String key, String word) throws SQLException {
		return ProductDaoImpl.getProductDao().searchProduct(key, word);
	}
	
	
	@Override
	public void insertProduct(ProductDto product) throws SQLException {
		ProductDaoImpl.getProductDao().insertProduct(product);
	}

	@Override
	public int deleteProduct(String id) throws SQLException {
		return ProductDaoImpl.getProductDao().deleteDao(id);
	}

	@Override
	public void updateProduct(ProductDto product) throws SQLException {
		ProductDaoImpl.getProductDao().updateDao(product);
	}

}
