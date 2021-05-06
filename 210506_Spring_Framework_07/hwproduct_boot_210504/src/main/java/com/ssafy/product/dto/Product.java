package com.ssafy.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MemberDto : 물품정보")
public class Product {
	
	@ApiModelProperty(value="물품번호")
	private String pid;
	
	@ApiModelProperty(value="물품명")
	private String pname;
	
	@ApiModelProperty(value="물품기격")
	private String price;
	
	@ApiModelProperty(value="물품설명")
	private String des;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", des=" + des + "]";
	}
	
	

}
