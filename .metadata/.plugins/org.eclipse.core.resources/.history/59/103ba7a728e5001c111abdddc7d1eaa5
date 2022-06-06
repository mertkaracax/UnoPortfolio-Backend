package com.uno.portfolio.bussiness;

import java.util.List;

import com.uno.portfolio.DTO.CapitalDTO;
import com.uno.portfolio.DTO.LoginResponseDTO;
import com.uno.portfolio.entities.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer deleteCustomer(String username);
	Customer updateCusomer(Customer customer);
	Customer findById(String username);
	List<Customer> getAll();
	LoginResponseDTO login(String username, String password);
	CapitalDTO changeCapital(String username, float amount);

}
