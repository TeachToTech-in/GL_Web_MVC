package com.rahul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	
	@Autowired
	private CurrencyService service;
	
	@GetMapping("currencyexchange/{from}/{to}")
	public Currency CurrencyRate(@PathVariable String from,@PathVariable String to) {
		return service.retrieve();
	}
}
