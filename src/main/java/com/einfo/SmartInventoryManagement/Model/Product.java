package com.einfo.SmartInventoryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private Integer productId;
	private String productname;
	private String productdecs;
	private Integer productquantity;
	private Integer productthreshold;
	private String productprice;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(Integer productId, String productname, String productdecs, Integer productquantity,
			Integer productthreshold, String productprice) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productdecs = productdecs;
		this.productquantity = productquantity;
		this.productthreshold = productthreshold;
		this.productprice = productprice;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getProductdecs() {
		return productdecs;
	}


	public void setProductdecs(String productdecs) {
		this.productdecs = productdecs;
	}


	public Integer getProductquantity() {
		return productquantity;
	}


	public void setProductquantity(Integer leftQuantity) {
		this.productquantity = leftQuantity;
	}


	public Integer getProductthreshold() {
		return productthreshold;
	}


	public void setProductthreshold(Integer productthreshold) {
		this.productthreshold = productthreshold;
	}


	public String getProductprice() {
		return productprice;
	}


	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}


	@Override
	public String toString() {
		return "Buyer [ product_Id=" + productId + ", product_name=" + productname
				+ ", product_decs=" + productdecs + ", product_quantity=" + productquantity + ", product_threshold="
				+ productthreshold + ", product_price=" + productprice + "]";
	}
	
	
	
}
