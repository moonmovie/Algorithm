package dto;

public class Product {
	private String id;
	private String name;
	private String price;
	private String des;
	private String adder;
	private String date;
	
	public Product() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		date = date;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", des=" + des + ", adder=" + adder
				+ ", date=" + date + "]";
	}

	
	
}
