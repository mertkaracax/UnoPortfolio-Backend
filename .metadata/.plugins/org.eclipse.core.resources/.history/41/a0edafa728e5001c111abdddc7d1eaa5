package com.uno.portfolio.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Asset")
public class Asset {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;

	public Asset(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Asset() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
