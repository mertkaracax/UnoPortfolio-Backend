package com.uno.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="username")
	String username;
	
	@Column(name="name")
	String name;
	
	@Column(name="surname")
	String surname;
	
	@Column(name="password")
	String password;
	
	@Column(name="cash")
	float cash;
	
	@Column(name="realized_pnl")
	float realized_pnl;
	
	

	public Customer() {
		super();
	}

	public Customer(String username, String name, String surname, String password) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.cash = 0;
		this.realized_pnl = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public float getRealized_pnl() {
		return realized_pnl;
	}

	public void setRealized_pnl(float realized_pnl) {
		this.realized_pnl = realized_pnl;
	}
	
	
	
	
	
	
	
	

}
