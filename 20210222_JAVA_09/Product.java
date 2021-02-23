package com.ssafy.abc;

import java.io.Serializable;

class Product implements Serializable {

	private static final long serialVersionUID = 7792435623962249526L;
	
	private int sirialNum;
	private String name;
	private int price;
	private int amount;
	
	public Product() {}
	public Product(int sirialNum, String name, int price, int amount) {
		super();
		this.sirialNum = sirialNum;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public int getSirialNum() {
		return sirialNum;
	}
	public void setSirialNum(int sirialNum) {
		this.sirialNum = sirialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "sirialNum=" + sirialNum + "| name=" + name + "| price=" + price + "| amount=" + amount;
	}
	
	
	
}
