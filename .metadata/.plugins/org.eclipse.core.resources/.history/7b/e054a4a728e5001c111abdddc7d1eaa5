package com.uno.portfolio.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.portfolio.dataAccess.IBalanceRepository;
import com.uno.portfolio.entities.Portfolio;
import com.uno.portfolio.entities.Purchase;


@Service
public class BalanceService implements IBalanceService{
	IBalanceRepository balanceRepository;

	@Autowired
	public BalanceService(IBalanceRepository balanceRepository) {
		super();
		this.balanceRepository = balanceRepository;
	}
	
	


	@Override
	public void purchase(String username, float price, float amount, float date, String asset) {
		balanceRepository.addPurchase(username, price, amount, date, asset);
		
	}




	@Override
	public void sell(String username, float price, float amount, float date, String asset) {
		balanceRepository.sell(username, price, amount, date, asset);
		
	}




	@Override
	public List<Portfolio> getBalance(String username) {
		return balanceRepository.getBalance(username);
	} 
	
	

	
	

}
