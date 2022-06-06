package com.uno.portfolio.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Purchase")
public class Purchase {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="price")
	private float price;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="purchase_date")
	private float purchase_date;
	
	@Column(name="asset")
	private String asset;

	public Purchase(String owner, float price, float amount, float purchase_date, String asset) {
		super();
		
		this.owner = owner;
		this.price = price;
		this.amount = amount;
		this.purchase_date = purchase_date;
		this.asset = asset;
	}

	public Purchase() {
		super();
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(float purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	

}
