package com.example.demo.domain;

 
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	private int id;
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="genrated_at")
	private Timestamp genratedAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDesc() {
		return productDesc;
	}
	
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	public Timestamp getGenratedAt() {
		return genratedAt;
	}
	
	public void setGenratedAt(Timestamp genratedAt) {
		this.genratedAt = genratedAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}
