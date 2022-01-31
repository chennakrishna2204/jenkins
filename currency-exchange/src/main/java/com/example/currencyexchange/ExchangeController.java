package com.example.currencyexchange;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
	
	@Autowired
	Environment environment;
	
	/*
	 * @Autowired CurrencyExchangeRepo CurrencyExchangeRepo;
	 */
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		CurrencyExchange currencyExchange = new CurrencyExchange();
		/*
		 * CurrencyExchange currencyExchange =
		 * CurrencyExchangeRepo.findByFromAndTo(from, to);
		 */
		currencyExchange.setEnvironment(environment.getProperty("server.port"));
		
		
		return currencyExchange;
	}
	
	

}
