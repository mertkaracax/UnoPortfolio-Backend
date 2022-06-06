package com.uno.portfolio.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.uno.portfolio.bussiness.IBalanceService;
import com.uno.portfolio.entities.Portfolio;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BalanceController {
	private IBalanceService balanceService;

	@Autowired
	public BalanceController(IBalanceService balanceService) {
		super();
		this.balanceService = balanceService;
	}
	
	@GetMapping("/balance/{username}")
	public ResponseEntity<List<Portfolio>> getBalance(@PathVariable String username){
		return new ResponseEntity<>(balanceService.getBalance(username), HttpStatus.OK);
	}
	@PostMapping("/balance/add/{username}/{price}/{amount}/{date}/{asset}")
	public ResponseEntity<String> purchase(@PathVariable String username,
			@PathVariable float price,@PathVariable float amount,
			@PathVariable float date,@PathVariable String asset)
	{
		balanceService.purchase(username, price, amount, date, asset);
		return new ResponseEntity<String>("balance updated",HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/balance/sell/{username}/{price}/{amount}/{date}/{asset}")
	public ResponseEntity<Void> sell(@PathVariable String username,
			@PathVariable float price,@PathVariable float amount,
			@PathVariable float date,@PathVariable String asset)
	{
		balanceService.sell(username, price, amount, date, asset);
		return ResponseEntity.noContent().build();
		
	}
	
	

}
