package com.uno.portfolio.dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uno.portfolio.entities.Customer;
import com.uno.portfolio.entities.Portfolio;
import com.uno.portfolio.entities.PortfolioPK;
import com.uno.portfolio.entities.Purchase;


@Repository
public class BalanceRepository implements IBalanceRepository{
	
	private EntityManager entityManager;
	
	@Autowired
	public BalanceRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public void addPurchase(String username, float price, float amount, float date, String asset) {
		Session session  = entityManager.unwrap(Session.class);
		
		//creating purchase entity
		Purchase purchase = new Purchase(username,price, amount, date, asset);
		
		//getting portfolio record from the database
		PortfolioPK pk = new PortfolioPK(asset,username);
		Portfolio portfolio = session.find(Portfolio.class, pk);
		
		//getting customer record 
		Customer customer = session.find(Customer.class, username);

		
		if(customer.getCash() < (amount*price)) {
			System.out.println("amount cannot be greater than curret cash value");
			return;
		}
		
		//meaning it is new purchase
		if(portfolio==null) {
			portfolio = new Portfolio(pk,amount, price);
		}
		
		// if it is already existing purchase then recalculate average_cost
		else {
			
			portfolio.setAverage_cost(calculate_average_cost(portfolio.getAmount(), portfolio.getAverage_cost(),amount, price));
			// new amount is addition of the old and current purchase amount
			portfolio.setAmount(amount + portfolio.getAmount());
		}
		customer.setCash(customer.getCash() - (amount*price) );
		session.saveOrUpdate(customer);
		session.saveOrUpdate(portfolio);
		session.saveOrUpdate(purchase);
		
	}
//	Portfolio portfolio = new Portfolio();
//	String hql = "from Portfolio where username=" + username + " AND asset=" + asset; 
//	portfolio = session.createQuery(hql,Portfolio.class).getSingleResult();
	


	@Override
	@Transactional
	public void sell(String username, float price, float amount, float date, String asset) {
		Session session  = entityManager.unwrap(Session.class);
		
		//crste purchase instant
		Purchase purchase = new Purchase(username,price, (-amount), date, asset);
		
		PortfolioPK pk = new PortfolioPK(asset,username);
		Portfolio portfolio = session.find(Portfolio.class, pk);
		
		//getting customer record 
		Customer customer = session.find(Customer.class, username);

		
		if(portfolio == null) {
			System.out.println("portfolio cannot be null");
			return;
		}else {
			if(portfolio.getAmount() < amount) {
				System.out.println("amount cannot be greater than current balance amount");
				return;
			}else {
				float realized_pnl = ((amount*price)-portfolio.getAverage_cost());
				customer.setRealized_pnl(customer.getRealized_pnl() + realized_pnl);
				customer.setCash(customer.getCash() + (amount*price));
				if(portfolio.getAmount() == amount) {
					deletePortfolioEntry(portfolio, session);
					session.saveOrUpdate(purchase);
					session.saveOrUpdate(customer);
					return;
				}
				//portfolio.setAverage_cost(calculate_average_cost(portfolio.getAmount(), portfolio.getAverage_cost(),(-amount), price));
				portfolio.setAmount(portfolio.getAmount() - amount);
				portfolio.setRealized_pnl(portfolio.getRealized_pnl() + realized_pnl);
				session.saveOrUpdate(customer);
				session.saveOrUpdate(portfolio);
				session.saveOrUpdate(purchase);
				return;
			}
		}
		
		
		
	}
	


	@Override
	@Transactional
	public List<Portfolio> getBalance(String username) {
		Session session  = entityManager.unwrap(Session.class);
		List<Portfolio> balance = new ArrayList<>();
		String hql = "from Portfolio where Username=" + "'" + username + "'";
		balance  = session.createQuery(hql, Portfolio.class).getResultList();
		return balance;
	}
	
	private void deletePortfolioEntry(Portfolio portfolio , Session session) {
		session.delete(portfolio);
	}
	

	private float calculate_average_cost(float old_amount , float old_average, float new_amount, float price) {
		float new_average = ((old_amount*old_average) + (new_amount*price))/(old_amount + new_amount);
		return new_average;
		
	}

}
