package com.ssafy.abc;

public class Product {

	private int sirialNum;
	private String name;
	private int price;
	private int amount;
	
	public Product() {}
	
	public Product(int sirialNum, String name, int price, int amount) {
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

	public String toString() {
		return "sirialNum=" + sirialNum + " | name=" + name + ", price=" + price + ", amount=" + amount ;
	}
	
}
