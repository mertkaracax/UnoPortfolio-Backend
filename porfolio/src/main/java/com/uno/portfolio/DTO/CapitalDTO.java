package com.uno.portfolio.DTO;

import org.springframework.stereotype.Component;

@Component
public class CapitalDTO {
	private String username;
	private float capital;
	public CapitalDTO(String username, float capital) {
		super();
		this.username = username;
		this.capital = capital;
	}
	public CapitalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getCapital() {
		return capital;
	}
	public void setCapital(float capital) {
		this.capital = capital;
	}
	
	
}
