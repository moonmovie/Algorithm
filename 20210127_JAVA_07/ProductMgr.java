package com.ssafy.abc.inter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMgr implements IProductMgr {
	ArrayList<Product> thing = new ArrayList<>();
	
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
		thing.add(p);
	}
	public void list() {
		System.out.println("----------------상품리스트----------------");
		for(int i=0;i<thing.size();i++) {
			System.out.println(thing.get(i));
		}
		System.out.println();
	}
	
//	public void list(List<Product> list) {
//		System.out.println("----------------하위 가격순 리스트----------------");
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println();
//	}
	
	public void search(int num) {
		System.out.println("----------------상품검색:"+num+"----------------");
		boolean flag = false;
		for(int i=0;i<thing.size();i++) {
			if(num==thing.get(i).getSirialNum()) {
				System.out.println(thing.get(i));
				flag = true;
			}
		}
		if(flag) {
			System.out.println();
		}else {
			System.out.println("검색 결과 없음");
		}
		
	}
	public void searchName(String name) {
		System.out.println("----------------상품이름으로 검색----------------");
		boolean flag = false;
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i).getName().contains(name)) {
				System.out.println(thing.get(i));
				flag=true;
			}
		}
		if(flag) {
			System.out.println();
		}else {
			System.out.println("검색 결과 없음");
		}
		
	}
	public void searchTV() {
		System.out.println("----------------상품검색: TV----------------");
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i) instanceof TV) {
				System.out.println(thing.get(i));
			}
		}
		System.out.println();
	}
	public void searchRe() {
		System.out.println("----------------상품검색:Refrigerator----------------");
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i) instanceof Refrigerator) {
				System.out.println(thing.get(i));
			}
		}
		System.out.println();
	}
	public void delete(int num) {
		System.out.println("----------------삭제상품:"+num+"----------------");
		boolean flag=false;
		for(int i=0;i<thing.size();i++) {
			if(num==thing.get(i).getSirialNum()) {
				thing.remove(i);
				flag=true;
			}
		}
		if(flag) {
			System.out.println("삭제 완료되었습니다");
			System.out.println();
			list();
		}else {
			System.out.println("해당 번호가 없습니다");
		}
		
	}
	public void priceList(int price) {
		System.out.println("----------------가격이하:"+price+"----------------");
		List<Product> newlist = new ArrayList();
		for(int i=0;i<thing.size();i++) {
			if(price>=thing.get(i).getPrice()) {
				newlist.add(thing.get(i));
			}
			
		Collections.sort(newlist,new Comparator<Product>() {
				@Override
				public int compare(Product a, Product b) {
					return a.getPrice()-b.getPrice();
				}
			});
		}
		for(int i=0;i<newlist.size();i++) {
			System.out.println(newlist.get(i));
		}
		System.out.println();
	}
	public void totalPrice() {
		System.out.println("----------------전체 재고 금액----------------");
		int total =0;
		for(int i=0;i<thing.size();i++) {
			total+=thing.get(i).getPrice();
		}
		System.out.println("전체 재고 금액 : "+total);
		System.out.println();
	}

	@Override
	public void searchRe400() {
		System.out.println("----------------400L이하----------------");
		boolean flag =false;
		List<Product> newlist = new ArrayList();
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i) instanceof Refrigerator) {
				Refrigerator refri = (Refrigerator)thing.get(i);
				if(refri.getL()<400) {
					newlist.add(refri);
					flag=true;
				}
			Collections.sort(newlist,new Comparator<Product>() {
					@Override
					public int compare(Product a, Product b) {
						return a.getPrice()-b.getPrice();
					}
				});	
			}
		}
		if(flag) {
			for(int i=0;i<newlist.size();i++) {
				System.out.println(newlist.get(i));
			}
			System.out.println();
		}else {
			System.out.println("해당 상품 없음");
		}
		
	}

	@Override
	public void searchTv50() {
		System.out.println("----------------50inch이상----------------");
		boolean flag=false;
		List<Product> newlist = new ArrayList();
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i) instanceof TV) {
				TV refri = (TV)thing.get(i);
				if(refri.getInch()>50) {
					newlist.add(refri);
					flag=true;
				}
				Collections.sort(newlist,new Comparator<Product>() {
					@Override
					public int compare(Product a, Product b) {
						return b.getPrice()-a.getPrice();
					}
				});	
			}
		}
		if(flag) {
			for(int i=0;i<newlist.size();i++) {
				System.out.println(newlist.get(i));
			}
			System.out.println();
		}else {
			System.out.println("해당 상품 없음");
		}
}

	@Override
	public void updatePrice(int num,int price) {
		boolean flag = false;
		for(int i=0;i<thing.size();i++) {
			if(thing.get(i).getSirialNum()==num) {
				thing.get(i).setPrice(price);
				flag=true;
			}
		}
		if(flag) {
			System.out.println("수정되었습니다.");
			list();
		}else {
			System.out.println("없는 상품번호입니다.");
		}
	}
}
