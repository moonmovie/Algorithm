package com.ssafy.abc.excepte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface IProductMgr {
	
	public void add(Product p);
	public void list();
	public void search(int num);
	public void searchName(String name);
	public void searchTV();
	public void searchRe();
	public void searchRe400();
	public void searchTv50();
	public void updatePrice(int num, int price);
	public void delete(int num);
	public void totalPrice();
	
}
class DuplicateException extends Exception{
	DuplicateException(String msg){
		super(msg);
	}
}
class CodeNotFoundException extends Exception{
	CodeNotFoundException(String msg){
		super(msg);
	}
}
class ProductNotFoundException extends Exception{
	ProductNotFoundException(String msg){
		super(msg);
	}
}
