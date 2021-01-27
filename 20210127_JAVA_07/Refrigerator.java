package com.ssafy.abc.inter;

public class Refrigerator extends Product {

	private int l;
	
	public Refrigerator() {}
	
	public Refrigerator(int sirialNum, String name, int price, int amount, int l) {
		super(sirialNum, name, price, amount);
		this.l=l;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return super.toString() + " | l=" + l;
	}

}
