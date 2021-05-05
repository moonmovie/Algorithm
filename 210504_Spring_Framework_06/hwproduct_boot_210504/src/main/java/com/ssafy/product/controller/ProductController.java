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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("V1 product Controller")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="물품목록", notes="물품 <big>전체목록</big>을 반환해 줍니다.")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Product> productlist(){
		List<Product> list = productService.selectAll();
		return list;
	}
	@ApiOperation(value="물품등록", notes="물품을 등록합니다.")
	@RequestMapping(value="/change", method=RequestMethod.POST)
	public int productadd(@RequestBody @ApiParam(value="등록 할 물품 정보", required=true) Product product){
		
		return productService.insertOne(product);
	}
	@ApiOperation(value="물품수정", notes="물품 수정해줍니다.")
	@RequestMapping(value="/change", method=RequestMethod.PUT)
	public int productup(@RequestBody @ApiParam(value="수정 할 물품 정보", required=true) Product product){
		System.out.println("product update");
		return productService.updateOne(product);
	}
	@ApiOperation(value="물품삭제", notes="물품을 삭제해줍니다.")
	@RequestMapping(value="/change/{pid}", method=RequestMethod.DELETE)
	public int productdelete(@PathVariable("pid") @ApiParam(value="삭제할 물품 정보", required=true) String id){
		System.out.println("product delete");
		int x=productService.deleteOne(id);
		System.out.println(x);
		return x;
	}
	@ApiOperation(value="물품정보", notes="물품번호를 통해 물품 하나의 정보를 반환합니다.")
	@RequestMapping(value="/{pid}", method=RequestMethod.GET)
	public Product product(@PathVariable("pid") @ApiParam(value="검색할 물품 번호", required=true) String id){
		
		return productService.selectOne(id);
	}
}
