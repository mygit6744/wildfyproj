package com.dto;

public class Product {

	private Integer prodid;
	private String prodname;
	private Integer price;
	
	
	public Product(Integer prodid, String prodname, Integer price) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.price = price;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
