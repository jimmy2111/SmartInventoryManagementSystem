package com.einfo.SmartInventoryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {

	@Id
	private Integer product_Id;
	private String product_name;
	private int product_quantity;
	private String product_price;
	public Integer getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(Integer product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public Order(Integer product_Id, String product_name, int product_quantity, String product_price) {
		super();
		this.product_Id = product_Id;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
