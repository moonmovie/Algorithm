package com.ssafy.product.dto;

import java.util.List;

public class Page extends Product{
//	List<Product> list;
	private int perpage;
	private int totalpage;
	
	public Page( int perpage, int totalpage) {
//		this.list = list;
		this.perpage = perpage;
		this.totalpage = totalpage;
	}
	
	
	
	
	
}
