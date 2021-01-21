package com.ssafy.abc;

class TV {
	private int productNum;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private String displayType;
	
	public TV() {}
	public TV(int productNum, String name, int price, int amount, int inch, String displayType) {
		this.productNum=productNum;
		this.name=name;
		this.price=price;
		this.amount=amount;
		this.inch=inch;
		this.displayType=displayType;
	}
	
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	@Override
	public String toString() {
		return "TV [productNum=" + productNum + " | name=" + name + " | price=" + price + " | amount=" + amount + " | inch="
				+ inch + " | displayType=" + displayType + "]";
	}
	
	
}

class Refrigerator{
	private int productNum;
	private String name;
	private int price;
	private int amount;
	private int l;
	
	public Refrigerator() {}
	
	public Refrigerator(int productNum, String name, int price, int amount, int l) {
		this.productNum=productNum;
		this.name=name;
		this.price=price;
		this.amount=amount;
		this.l=l;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
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

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return "Refrigerator [productNum=" + productNum + " | name=" + name + " | price=" + price + " | amount=" + amount
				+ " | l=" + l + "]";
	}
	
	
}
