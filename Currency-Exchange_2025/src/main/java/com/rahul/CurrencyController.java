package com.rahul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment enviornment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//http://localhost:8080//currency-exchange/from/USD/to/INR
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange curr = repository.findByFromAndTo(from, to);
		curr.setEnvirnoment(enviornment.getProperty("local.server.port"));
		return curr;
	}
}
