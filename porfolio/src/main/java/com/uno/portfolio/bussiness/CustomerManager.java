package com.uno.portfolio.bussiness;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.portfolio.DTO.CapitalDTO;
import com.uno.portfolio.DTO.LoginResponseDTO;
import com.uno.portfolio.dataAccess.ICustomerRepository;
import com.uno.portfolio.entities.Customer;

@Service
public class CustomerManager implements ICustomerService{
	ICustomerRepository customerRepository;
	

	@Autowired
	public CustomerManager(ICustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerRepository.addCustomer(customer);
	}

	
	@Override
	@Transactional
	public Customer deleteCustomer(String username) {
		return customerRepository.deleteCustomer(username);
	}

	
	@Override
	@Transactional
	public Customer updateCusomer(Customer customer) {
		return customerRepository.updateCusomer(customer);
	}

	@Override
	@Transactional
	public Customer findById(String username) {
		return customerRepository.findById(username);
	}
	
	@Override
	@Transactional
	public List<Customer> getAll(){
		return customerRepository.getAll();
	}
	
	
	@Override
	@Transactional
	public LoginResponseDTO login(String username, String password) {
		LoginResponseDTO response = new LoginResponseDTO();
		Customer found = customerRepository.findById(username);
		if(found == null){
			response.setNonPresentUsername();
		}else {
			if(password.equals(found.getPassword())) {
				response.setSuccessfulLogin();
			}else {
				response.setIncorrectPassword();
			}
		}
		return response;
	}

	@Override
	public CapitalDTO changeCapital(String username, float amount) {
		return customerRepository.changeCapital(username, amount);
		
	}
	
	

}
