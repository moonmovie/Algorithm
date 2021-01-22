package com.ssafy.abc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMgr {
	final int MAX_SIZE = 100;
	int size=0;
	private Product[] thing= new Product[MAX_SIZE];
	
	private static ProductMgr manager = new ProductMgr();
	
	private ProductMgr() {}
	
	public static ProductMgr getInstance() {
		if(manager==null) {
			manager=new ProductMgr();
			return manager;
		}
		return manager;
	}
	
	public void add(Product p) {
		thing[size]=p;
		size++;
	}
	public void list() {
		System.out.println("----------------상품리스트----------------");
		for(int i=0;i<size;i++) {
			System.out.println(thing[i]);
		}
		System.out.println();
	}
	
	public void list(List<Product> list) {
		System.out.println("----------------하위 가격순 리스트----------------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}
	
	public void search(int num) {
		System.out.println("----------------상품검색:"+num+"----------------");
		for(int i=0;i<size;i++) {
			if(num==thing[i].getSirialNum()) {
				System.out.println(thing[i]);
			}
		}
		System.out.println();
	}
	public void delete(int num) {
		System.out.println("----------------삭제상품:"+num+"----------------");
		for(int i=0;i<size;i++) {
			if(num==thing[i].getSirialNum()) {
				for(int j=i;j<size-1;j++) {
					thing[j]=thing[j+1];
				}
				size--;	
			}
		}
		System.out.println();
		list();
	}
	public void priceList(int price) {
		System.out.println("----------------가격이하:"+price+"----------------");
		List<Product> newlist = new ArrayList();
		Product[] list = new Product[size];
		for(int i=0;i<size;i++) {
			if(price>=thing[i].getPrice()) {
				newlist.add(thing[i]);
			}
			
		Collections.sort(newlist,new Comparator<Product>() {
				@Override
				public int compare(Product a, Product b) {
					return a.getPrice()-b.getPrice();
				}
			});
		}
		list(newlist);
		System.out.println();
	}

	
}
