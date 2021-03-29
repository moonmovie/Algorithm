package dto;

public class Product {
	private String name;
	private String price;
	private String des;
	
	public Product() {
	}

	public Product(String name, String price, String des) {
		this.name = name;
		this.price = price;
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	

}
