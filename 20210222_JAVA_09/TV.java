package com.ssafy.abc;

public class TV extends Product{
	private int inch;
	private String displayType;
	
	public TV() {}
	public TV(int sirialNum, String name, int price, int amount, int inch, String displayType) {
		super(sirialNum, name, price, amount);
		this.inch=inch;
		this.displayType=displayType;
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
		return super.toString()+" | inch=" + inch + " | displayType=" + displayType;
	}

}
