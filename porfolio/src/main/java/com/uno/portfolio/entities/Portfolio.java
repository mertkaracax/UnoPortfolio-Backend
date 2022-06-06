package com.uno.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Portfolio")
public class Portfolio {
	@EmbeddedId
	private PortfolioPK pk;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="average_cost")
	private float average_cost;
	
	@Column(name="realized_pnl")
	private float realized_pnl;

	public Portfolio(PortfolioPK pk, float amount, float average_cost) {
		super();
		this.pk = pk;
		this.amount = amount;
		this.average_cost = average_cost;
		this.realized_pnl = 0;
	}

	public Portfolio() {
		super();
	}

	public PortfolioPK getPk() {
		return pk;
	}

	public void setPk(PortfolioPK pk) {
		this.pk = pk;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getAverage_cost() {
		return average_cost;
	}

	public void setAverage_cost(float average_cost) {
		this.average_cost = average_cost;
	}
	
	public float getRealized_pnl() {
		return realized_pnl;
	}

	public void setRealized_pnl(float realized_pnl) {
		this.realized_pnl = realized_pnl;
	}
	
	
	

}
