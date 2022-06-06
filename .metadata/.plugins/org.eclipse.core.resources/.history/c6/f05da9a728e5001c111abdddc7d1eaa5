package com.uno.portfolio.dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uno.portfolio.DTO.CapitalDTO;
import com.uno.portfolio.entities.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository{
	 	private EntityManager entityManager;

	    @Autowired
	    public CustomerRepository(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }

		@Override
		@Transactional
		public Customer addCustomer(Customer customer) {
			Session session  = entityManager.unwrap(Session.class);
			if((findById(customer.getUsername()))==null) {
				session.saveOrUpdate(customer);
				return customer;
			}
			return null;
		}

		@Override
		@Transactional
		public Customer deleteCustomer(String username) {
			Session session  = entityManager.unwrap(Session.class);
			Customer customer;
			if((customer=findById(username))!=null) {
				session.delete(customer);
				return customer;
			}
			return null;
		}

		@Override
		@Transactional
		public Customer updateCusomer(Customer customer) {
			Session session  = entityManager.unwrap(Session.class);
			if(findById(customer.getUsername())==null) {
				session.saveOrUpdate(customer);
				return customer;
			}
			return null;
		}
		
		
		@Override
		@Transactional
		public Customer findById(String username) {
			Session session  = entityManager.unwrap(Session.class);
			Customer customer = session.get(Customer.class,username);
			return customer;
		}

		@Override
		@Transactional
		public List<Customer> getAll() {
			Session session  = entityManager.unwrap(Session.class);
			List<Customer> customers = new ArrayList<Customer>();
			customers = session.createQuery("from Customer",Customer.class).getResultList();
			return customers;
			
		}

		@Override
		@Transactional
		public CapitalDTO changeCapital(String username, float amount) {
			Session session  = entityManager.unwrap(Session.class);
			Customer customer = session.find(Customer.class, username);
			float newCash = customer.getCash() + amount;
			customer.setCash(newCash);
			session.saveOrUpdate(customer);
			CapitalDTO capital = new CapitalDTO(username , newCash);
			return capital;
		}

	    
	   
	    


}
