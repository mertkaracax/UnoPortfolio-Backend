package com.uno.portfolio.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.uno.portfolio.DTO.CapitalDTO;
import com.uno.portfolio.DTO.LoginResponseDTO;
import com.uno.portfolio.bussiness.ICustomerService;
import com.uno.portfolio.entities.Customer;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class UserController {
	private ICustomerService customerService;

	@Autowired
	public UserController(ICustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		
		if(customerService.addCustomer(customer)==null) {
			return new ResponseEntity<>(customer,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public List<Customer> getAllCustomers(){
		return customerService.getAll();
	}
	
	@GetMapping("/users/{username}")
	public Customer getById(@PathVariable String username) {
		return customerService.findById(username);
	}
	
	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<LoginResponseDTO> login (@PathVariable String username,  @PathVariable String password){
		LoginResponseDTO response = customerService.login(username,password);
		if(response.isLoginSuccessful()) {
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/change/capital/{username}/{amount}")
	public ResponseEntity<CapitalDTO> changeCapital(@PathVariable String username,  @PathVariable float amount){
				
		return new ResponseEntity<>(customerService.changeCapital(username, amount), HttpStatus.OK);
	}
	//http://localhost:8080/api/customer/change/capital/{username}/{amount}
	
	
}

