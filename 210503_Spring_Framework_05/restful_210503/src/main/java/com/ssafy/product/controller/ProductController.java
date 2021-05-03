package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.dto.Product;
import com.ssafy.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Product> productlist(){
		List<Product> list = productService.selectAll();
		return list;
	}
	
	@RequestMapping(value="/change", method=RequestMethod.POST)
	public int productadd(@RequestBody Product product){
		
		return productService.insertOne(product);
	}
	
	@RequestMapping(value="/change", method=RequestMethod.PUT)
	public int productup(@RequestBody Product product){
		System.out.println("product update");
		return productService.updateOne(product);
	}
	
	@RequestMapping(value="/change/{pid}", method=RequestMethod.DELETE)
	public int productdelete(@PathVariable("pid") String id){
		System.out.println("product delete");
		int x=productService.deleteOne(id);
		System.out.println(x);
		return x;
	}
	@RequestMapping(value="/{pid}", method=RequestMethod.GET)
	public Product product(@PathVariable("pid") String id){
		
		return productService.selectOne(id);
	}
}
