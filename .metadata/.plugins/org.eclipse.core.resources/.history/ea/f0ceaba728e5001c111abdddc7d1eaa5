package com.uno.portfolio.dataAccess;

import java.util.List;

import com.uno.portfolio.entities.Portfolio;

public interface IBalanceRepository {
	void addPurchase(String username, float price, float amount, float date, String asset);
	void sell(String username, float price, float amount, float date, String asset);
	List<Portfolio> getBalance(String username);
}
